package grammar.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionInterfaces {
    /**
        ## 어떤 컬렉션을 쓸가
        - Collection vs Iterable vs List ??
        - 컬렉션이 표현하는 개념
            - 크기
            - 원소간 순서
            - 원소의 독자성 
        - 켈렉션을 선택했다는 것은 개발자의 성능에 대한 의도를 드러낸다
        - 자바 컬렉션이 수학의 집합과 차이점은 
            - 합집합, 교집합, 차집합 이런게 없다.  
    */
    
    @Test
    @DisplayName("배열: 크기 고정. 가장 단순한 형태")
    public void array() {
        String[] names = {"matthew", "marin", "phillip"};
        assertEquals("marin", names[1]);
    }

    @Test
    @DisplayName("Iterable : 순차 열람. forEach를 쓸 수 있다.")
    public void iterable() {
        Iterable<String> iter = Arrays.asList("matthew", "marin", "phillip");
        iter.forEach(name -> {
            System.out.println(name);
        });
    }

    @Test
    @DisplayName("Collection : Iterable에 원소 추가, 제거 기능이 더 있다.")
    public void collection() {
        // ArrayList는 Collection의 가장 기본적인 구현체이다.
        Collection<String> collection = new ArrayList<>(); 
        collection.add("matthew");
        assertTrue(collection.contains("matthew"));
    }

    @Test
    @DisplayName("List : 원소의 순서가 있으며, 위치 정보(index)를 통해 접근 가능")
    public void list() {
        var names = new ArrayList<String>();
        names.addAll(List.of("matthew", "tomas", "minjun"));
        assertEquals("minjun", names.get(2));
    }

    @Test
    @DisplayName("Set : 중복된 원소가 없는 컬렉션")
    public void set() {
        var coupons = new HashSet<String>();
        coupons.addAll(List.of("matthew", "tomas", "minjun", "tomas"));
        assertNotEquals(4, coupons.size());
        assertEquals(3, coupons.size());
    }

    @Test
    @DisplayName("Map : 키(key)에 의해 원소에 접근")
    public void map() {
        Map<String, String> persons = new HashMap<>();
        persons.put("a101", "matthew");
        persons.put("a102", "jun");
        assertEquals("jun", persons.get("a102"));
        assertEquals(2, persons.size());
    }


}

