package grammar.variables;

public class Characters {
    public static void main(String[] args) {
        // char
        // 문자를 취급하는 자료형이다.
        // 작은따옴표로 감싸준다.
        // 두글자 이상 사용할 수 없다.

        char charA = '가';
        IO.println(charA);

        // String
        // 문자열을 다룰때 사용한다. char는 문자 하나만 다루지만 String은 문자 여러개를 다룬다.
        // 큰따옴표로 감싸준다.
        // String 은 원시타입(primitive type) 이 아니다.
        // 원시타입은 int, boolean 과 같이 자료형 이름이 소문자로 시작하지만 String은 대문자로 시작한다.
        // 자바에서는 관행적으로 참조타입은 첫글자로 대문자를 사용한다.
        // 참조타입(reference type) 이지만 원시 타입보다 더 많이 사용되기때문에
        // 자바에서 String은 원시타입 만큼이나 특별한 취급을 받는다.

        String hello = "안녕하세요";
        IO.println(hello);

    }
}
