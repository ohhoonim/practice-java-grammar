package std.regularExpression;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    // java.util.regex.Pattern 
    // 정규식 문법은 Pattern api 문서 참조
    public static void main(String[] args) {
        Pattern p = Pattern.compile("a*b"); // a로 시작해서 b로 끝나는 패턴 
        Matcher m = p.matcher("aaaaab"); // 패턴에 "aaaaab"문자열을 체크한다고 등록
        boolean result = m.matches();  // 결과출력 
        IO.println(result);   

        // 아래처럼 사용해도 됨.
        boolean result2 = Pattern.matches("a*b", "aaaaab");
        IO.println(result2);

        // 함수형 프로그래밍
        Predicate<String> matchTest = p.asMatchPredicate();
        boolean result3 = matchTest.test("aaaabcc");
        IO.println(result3);
    }
}
