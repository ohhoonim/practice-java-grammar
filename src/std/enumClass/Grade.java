package std.enumClass;

import java.util.function.Function;

public enum Grade {
    Top((type) -> {
        return switch(type) {
            case Alphabet -> "A";
            case Hangul -> "수";
            default -> "수";
        };
    }),
    Middle((type) -> {
        return switch(type) {
            case Alphabet -> "B";
            case Hangul -> "우";
            default -> "우";
        };
    }),
    Bottom((type) -> {
        return switch(type) {
            case Alphabet -> "C";
            case Hangul -> "미";
            default -> "미";
        };
    }),
    Fail((type) -> {
        return switch(type) {
            case Alphabet -> "D";
            case Hangul -> "양";
            default -> "양";
        };
    }),
    None((type) -> {
        return switch(type) {
            case Alphabet -> "X";
            case Hangul -> "가";
            default -> "가";
        };
    });

    private final Function<GradeType, String> expression;

    private Grade(Function<GradeType, String> expression) {
        this.expression = expression;
    }

    public String toGradeString(GradeType type) {
        return expression.apply(type);
    }
}
