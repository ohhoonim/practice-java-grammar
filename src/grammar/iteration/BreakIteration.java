package grammar.iteration;

public class BreakIteration {
    public static void main(String[] args) {
        IO.println("break, continue");

        // for문에서 break
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8 };
        for(int i = 0; i < numbers.length; i++) {
            if ( numbers[i] == 5) {
                break;
            } else {
                IO.println(numbers[i]);
            }
        }
        
        // for문에서 continue
        for(int i = 0; i < numbers.length; i++) {
            if ( numbers[i] % 2 == 0) {
                continue;
            } else {
                IO.println(numbers[i]);
            }
        }

    }
}
