package grammar.variables;

public class Number {
    public static void main(String[] args) {
        // 주석 : 실행되지 않는 코드 영역. 슬래시 두개는 한 줄 주석
        // 변수명의 첫글자는 영문 또는 _(언더스코어)로 시작해야한다.
        // 언더스코어 이외의 특수문자는 사용할 수 없다.

        // 정수형 int 4바이트 (32비트)
        // 대략 -21억부터 +21억까지 사용가능하다.
        // 숫자형중 가장 많이 사용되는 형태이다.
        int intX = 987050;
        // 세미콜론(;) 은 코드 문장의 끝을 표시함.
        // IO.println() 은 터미널에 값을 출력할 때 사용
        IO.println(intX); // x 값을 출력

        // 정수형 short 2바이트(16비트)
        // 대략 -3만2천부터 +3만 2천까지 쓸 수 있다.
        short shortX = 28935;
        IO.println(shortX);

        // 정수형 long 8바이트(64비트)
        // -2^63 부터 2^63-1 까지 쓸수 있다. 무지 큰 숫자를 사용할 수 있다는 것임
        long longX = 23423414642314l;
        IO.println(longX);
        
        // 실수형 float
        float floatX = 234234.2234f;
        IO.println(floatX);
        
        // 실수형 double 
        // float형보다 더 큰 사용범위를 가진다. 
        // 자바에서 소수점이 있는 숫자를 처리하는 기본 방식
        double doubleX = 234.235;
        IO.println(doubleX);
        
        // (주의)
        // 컴퓨터에서 소수점이 있는 숫자를 계산할 때는 근본적인 문제가 있다. 
        // 자바에서 소수점을 이용한 계산을 할때에는 별도 방법을 이용해야한다.
    }
}
