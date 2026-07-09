package std.enumClass;

import java.util.function.Supplier;

public enum Day implements Supplier<String> {
    Monday("월", 2),
    Sunday("일", 1),
    Tuesday("화", 3),
    Wednesday("수", 4),
    Thursday("목", 5),
    Friyday("금", 6),
    Saturday("토", 7);

    private final String kor;
    private final int order;

    private Day(String kor, int order) {
        this.kor = kor;
        this.order = order;
    }

    public int index() {
        return order;
    }

    @Override
    public String get() {
        return this.kor;
    }
}
