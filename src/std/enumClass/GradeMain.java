package std.enumClass;

public class GradeMain {
    public static void main(String[] args) {
        var result = Grade.Top.toGradeString(GradeType.Hangul);
        IO.println(result);
        var result2 = Grade.Top.toGradeString(GradeType.Alphabet);
        IO.println(result2);
    }
}
