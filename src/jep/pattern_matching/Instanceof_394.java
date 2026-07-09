package jep.pattern_matching;

public class Instanceof_394 {
    public static void main(String[] args) {
       test(new Point(10, 23)); 
    }

    static void test(Object o) {
        if (o instanceof Point p) {
            IO.println(String.format("%s, %s", p.x(), p.y()));
        } else {
            IO.print("point 타입이 아닙니다.");
        }
    }
}

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x() {
        return this.x;
    }

    int y() {
        return this.y;
    }
}