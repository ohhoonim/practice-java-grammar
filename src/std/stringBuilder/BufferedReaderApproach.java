package std.stringBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class BufferedReaderApproach {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(
                "StringBuilder\nBufferedReader Approach\r\nLine by Line Reading\rAnother line");
        try (BufferedReader reader = new BufferedReader(new StringReader(sb.toString()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                IO.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
