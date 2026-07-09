package std.enumClass;

import java.util.List;

public class EnumMain {
    public static void main(String[] args) {
        Day day = Day.Sunday;

        IO.println(day.index());

        IO.println(day.name());

        IO.println(List.of(Day.values()));

        IO.println(day.get());
    }
}
