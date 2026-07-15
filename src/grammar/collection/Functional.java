package grammar.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Functional {

    @Test
    @DisplayName("Consumer<T>")
    public void consumer() {
        Consumer<String> eat = (food) -> System.out.println(food);
        eat.accept("apple");
    }

    @Test
    @DisplayName("Supplier<T>")
    public void supplier() {
        Supplier<Integer> salary = () -> 300;
        Integer may = salary.get();
        assertEquals(300, may);
    }

    @Test 
    @DisplayName("Function<T, R>")
    public void function() {
        Function<BigDecimal, BigDecimal> exchange = (dallar) -> dallar.multiply(BigDecimal.valueOf(1600));
        BigDecimal exchanged = exchange.apply(BigDecimal.valueOf(43.27));
        assertEquals(BigDecimal.valueOf(69232).doubleValue(), exchanged.doubleValue());
    }

    @Test
    @DisplayName("Predicate<T>")
    public void predicate() {
        Predicate<String> predict = (name) -> "jane".equals(name);
        boolean isJane = predict.test("matthew");
        assertFalse(isJane);
    }

    @Test
    @DisplayName("Runner")
    public void functionalParams() {

        Function<Integer, Grade> schoolGradeCalcurator = (score) -> {
            int gradeNum = score/10;
            Grade result = switch(gradeNum) {
                case 9 -> Grade.A;
                case 8 -> Grade.B;
                case 7 -> Grade.C;
                case 6 -> Grade.D;
                default -> Grade.F;
            };
            return result;
        };

        Grade resultGrade = getGradeByScore(79, schoolGradeCalcurator);
        assertEquals(Grade.C, resultGrade);

    }

    private Grade getGradeByScore(int score, Function<Integer, Grade> calcurator) {
        return calcurator.apply(score);
    }

    enum Grade {
        A, B, C, D, F
    }
}