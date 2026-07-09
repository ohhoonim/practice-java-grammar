package jep.pattern_matching;

public class Switch_441 {
    void main() {


    }

    // 1. 타입 패턴 (Type Patterns)
    static String formatterPatternSwitch(Object obj) {
        return switch (obj) {
            case String s -> String.format("문자열: %s", s);
            case Integer i -> String.format("정수: %d", i);
            case Double d -> String.format("실수: %f", d);
            default -> obj.toString();
        };
    }

    // 2. when 절을 이용한 조건부 매칭 (Guarded Patterns)
    static void testString(Object obj) {
        switch (obj) {
            // String 타입이면서 길이가 5보다 큰 경우
            case String s when s.length() > 5 -> IO.println("긴 문자열: " + s);
            case String s -> IO.println("짧은 문자열: " + s);
            default -> {
            }
        }
    }

    // 3. Null 처리 가능 (Null-Friendliness)
    static void testNull(Object obj) {
        switch (obj) {
            case null -> IO.println("널 값이 들어왔습니다.");
            case String s -> IO.println(s);
            default -> IO.println("기타 객체");
        }
    }

    // JEP 440(Record Patterns)과의 시너지
    static void printShape(Object obj) {
    switch (obj) {
        case Point(int x, int y) -> 
            IO.println("좌표 점: " + x + ", " + y);
        case Rectangle(Point tl, Point br) -> 
            IO.println("사각형 영역 크기 계산 필요...");
        default -> 
            IO.println("알 수 없는 도형");
    }
}

}

record Rectangle(Point tl, Point br) {}
record Point(int x, int y) {}

