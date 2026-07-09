package jep.pattern_matching;

public class Record_440 {
    public static void main(String[] args) {

        var obj = new Point(23, 4);

        if (obj instanceof Point(int x, int y)) { // x, y를 바로 구조분해가 가능하다.
            IO.println(String.format("x: %s, y: %s", x, y));
        }
    }
}


record Point(int x, int y) {
}
