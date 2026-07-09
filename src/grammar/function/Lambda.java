package grammar.function;

import java.util.function.Function;

public class Lambda {
    public static void main(String[] args) {
        // 맛보기. 자바에서 람다식은 별도로 공부해야하는 영역
        // 화살표로 이렇게 표현할 수도 있다 정도로만 이해
        Function<Integer, Integer> fnDouble = a -> 2 * a;

        int y = fnDouble.apply(7);
        IO.println(y);

        // 1. 위 람다식을 괄호를 넣어 표현하자면 아래와 동일
        Function<Integer, Integer> fnDocublBrace = ( a ) -> {
            return 2 * a;
        };
        y = fnDocublBrace.apply(4);
        IO.println(y);

        // 2. 위 람다식을 메서드(하단의 methodDouble 메서드 참조)로 표현할 수 도 있다. 

        // 3. 굳이 람다식을 사용하는 이유는 코딩 패러다임때문임
        // c언어와 같이 구조적 코딩과 (일반적으로 절차식이라 불리는)
        // java언어와 같이 객체지향 코딩 그리고
        // lisp언어의 함수형 코딩이 있다
        // 상황에 맞게 적절하게 사용하면 된다. 
    }

    public static Integer methodDouble(Integer x) {
        return 2 * x;
    }
}
