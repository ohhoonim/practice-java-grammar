package std.stringBuilder;

import java.io.StringReader;
import java.util.Scanner;

public class ScannerApproach {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(
            "StringBuilder\nScanner Approach\r\nLine by Line Reading\rAnother line"
        );
        Scanner scanner = new Scanner(new StringReader(sb.toString()));
        while (scanner.hasNextLine()) {
            IO.println(scanner.nextLine());
        }
        scanner.close();
    }
}
