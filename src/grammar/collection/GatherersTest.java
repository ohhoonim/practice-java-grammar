package grammar.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class GatherersTest {

    @Test
    public void noneGatherer() {
        // jdk 24 세팅을 위한 테스트 
        var result = Stream.of(1, 2, 3, 4, 5)
                .map(i -> i * 2)
                .toList();
        assertThat(result).containsExactly(2, 4, 6, 8, 10);
    }

    @Test
    public void motivationGathererStep1() {
        // 스트림 파이프라인은 세 부분으로 구성된다
        // 1. 데이터 소스 : Stream.of("the", "", "fox", "jumps", "over", "the", "", "dog")
        // 2. (여러개의) 중간 연산 intermediate operations : filter(Predicate.not(String::isEmpty))
        // 3. (하나의) 최종 연산 terminal operation: collect(Collectors.counting())
        var numberOfWords = Stream.of("the", "", "fox", "jumps", "over", "the", "", "dog") // (1)
                .filter(Predicate.not(String::isEmpty)) // (2)
                .collect(Collectors.counting()); // (3) 

        assertThat(numberOfWords).isEqualTo(6);
    }

    @Test
    public void motivationGathererStep2() {
        // 문자열 길이를 기준으로 하나씩만 출력하는 예제
        // var result = Stream.of("foo", "bar", "baz", "quux")
        //         .distinctBy(String::length) // distinctBy 이런건 Stream에 없다
        //         .toList();
        // assertThat(result).containsExactly("foo", "quux");

        record DistinctByLength(String str) {
            @Override
            public boolean equals(Object obj) {
                return obj instanceof DistinctByLength(String other)
                        && str.length() == other.length();
            }

            @Override
            public int hashCode() {
                return str == null ? 0 : Integer.hashCode(str.length());
            }
        }

        var result = Stream.of("foo", "bar", "baz", "quux")
                .map(DistinctByLength::new)
                .distinct()
                .map(DistinctByLength::str)
                .toList();

        assertThat(result).containsExactly("foo", "quux");
    }

    @Test
    public void motivationGathererStep3() {
        // 작업이 요소를 고정된 크기의 3개 그룹으로 그룹화하지만 처음 두 그룹만 유지
        // var result = Stream.iterate(0, i -> i + 1) // [0,1,2,3,4,5,...]
        //            .windowFixed(3)                 // 이런건 없다  
        //            .limit(2)
        //            .toList();
        // result ==> [[0, 1, 2], [3, 4, 5]]

        var result = Stream.iterate(0, i -> i + 1)
                .limit(3 * 2)
                .collect(Collector.of(
                        () -> new ArrayList<ArrayList<Integer>>(),
                        (groups, element) -> {
                            if (groups.isEmpty() || groups.getLast().size() == 3) {
                                var current = new ArrayList<Integer>();
                                current.add(element);
                                groups.addLast(current);
                            } else {
                                groups.getLast().add(element);
                            }
                        },
                        (left, right) -> {
                            throw new UnsupportedOperationException("Cannot be parallelized");
                        }));
        assertThat(result).hasSize(2);
        assertThat(result.get(0)).containsExactly(0, 1, 2);
        assertThat(result.get(1)).containsExactly(3, 4, 5);
    }

    @Test
    public void motivationGathererSummary() {
        // intermediate operation을 확장하는 확장 지점이 필요하다.
        // 이에 걸맞는 시그니처가 Stream::collect(Collector) 라는 결론에 도달했고
        // 이러한 형태로 Stream::gather(Gatherer)로 collector와 비슷한 
        // 접근 방식을 선택하였다.
    }

    ///////////////////////////////////////////////////////////////// example
    record Reading(Instant obtainedAt, int kelvins) {

        Reading(String time, int kelvins) {
            this(Instant.parse(time), kelvins);
        }

        // 시간으로 정렬된 온도 측정 결과 목록이 있다고 가정해보자 
        static Stream<Reading> loadRecentReadings() {
            return Stream.of(
                    new Reading("2023-09-21T10:15:30.00Z", 310),
                    new Reading("2023-09-21T10:15:31.00Z", 312),
                    new Reading("2023-09-21T10:15:32.00Z", 350),
                    new Reading("2023-09-21T10:15:33.00Z", 310));
        }
    }

    // 측정시간이 5초이내이면서 두 개의 온도 측정값이 30도 이상 차이를 감지
    boolean isSuspicious(Reading previous, Reading next) {
        return next.obtainedAt().isBefore(previous.obtainedAt().plusSeconds(5))
                && (next.kelvins() > previous.kelvins() + 30
                        || next.kelvins() < previous.kelvins() - 30);
    }

    @Test
    public void exampleGathererNoUse() {
        // gatherer를 사용하지 않으면 스트림의 순차적 스캔이 필요하므로
        // 선언적 스트림 처리를 피하고 로직을 구현해야한다
        var source = Reading.loadRecentReadings();
        var suspicious = new ArrayList<List<Reading>>();
        Reading previous = null;
        boolean hasPrevious = false;

        for (Reading next : source.toList()) {
            if (!hasPrevious) {
                hasPrevious = true;
                previous = next;
            } else {
                if (isSuspicious(previous, next)) {
                    suspicious.add(List.of(previous, next));
                }
                previous = next;
            }
        }

        // static Stream<Reading> loadRecentReadings() {
        //     return Stream.of(
        //             new Reading("2023-09-21T10:15:30.00Z", 310),
        //             new Reading("2023-09-21T10:15:31.00Z", 312), <<--
        //             new Reading("2023-09-21T10:15:32.00Z", 350), <<--
        //             new Reading("2023-09-21T10:15:33.00Z", 310)); <<--
        // }

        // System.out.println(suspicious);
        // [[Reading[obtainedAt=2023-09-21T10:15:31Z, kelvins=312], Reading[obtainedAt=2023-09-21T10:15:32Z, kelvins=350]], 
        // [Reading[obtainedAt=2023-09-21T10:15:32Z, kelvins=350], Reading[obtainedAt=2023-09-21T10:15:33Z, kelvins=310]]]

        assertThat(suspicious.get(0)).containsExactly(
                new Reading("2023-09-21T10:15:31Z", 312),
                new Reading("2023-09-21T10:15:32Z", 350));
        assertThat(suspicious.get(1)).containsExactly(
                new Reading("2023-09-21T10:15:32Z", 350),
                new Reading("2023-09-21T10:15:33Z", 310));
    }

    @Test
    public void exampleGathererUse() {
        var source = Reading.loadRecentReadings();
        var suspicious = source.gather(Gatherers.windowSliding(2))
                .filter(window -> (window.size() == 2 && isSuspicious(window.get(0), window.get(1))))
                .toList();

        assertThat(suspicious.get(0)).containsExactly(
                new Reading("2023-09-21T10:15:31Z", 312),
                new Reading("2023-09-21T10:15:32Z", 350));
        assertThat(suspicious.get(1)).containsExactly(
                new Reading("2023-09-21T10:15:32Z", 350),
                new Reading("2023-09-21T10:15:33Z", 310));
    }

    ////////////////////////////////////////////////////////////// gatherer 내장 함수
    @Test
    public void windowSlidingTest() {
        var source = Stream.of(1, 2, 3, 4, 5);
        var result = source.gather(Gatherers.windowSliding(3))
                .toList();

        assertThat(result).hasSize(3);
        assertThat(result.get(0)).containsExactly(1, 2, 3);
        assertThat(result.get(1)).containsExactly(2, 3, 4);
        assertThat(result.get(2)).containsExactly(3, 4, 5);
    }

    @Test
    public void windowFixedTest() {
        var source = Stream.of(1, 2, 3, 4, 5);
        var result = source.gather(Gatherers.windowFixed(3))
                .toList();

        assertThat(result).hasSize(2);
        assertThat(result.get(0)).containsExactly(1, 2, 3);
        assertThat(result.get(1)).containsExactly(4, 5);
    }

}