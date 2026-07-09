package grammar.function;

public class Method {
    public static void main(String[] args) {
        IO.println("method");

        // 1. 메서드는 특정 기능을 수행하는 함수이다.
        int a = 2;
        int b = 3;
        int y = plus(a, b); // 2. plus 메서드를 보자 
        IO.println(y);
        
        // 변수의 scope (중요)
        // 변수 a, b가 plus 메서드의 i, j 로 입력이 되면 plus 메서드가 처리된 이후
        // a, b 값을 바꿔도 plus메서드의 처리 결과인 y는 변하지 않는다.
        a = 4;
        IO.println(y);

        // 변수는 동일한 이름으로 두번 선언할 수 없다.
        if (true) {
            // int a = 5;   // <- 에러 
        }

        // 변수는 상위 괄호에서 사용할 수 없다.
        if (true) {
            int d = 6;
        }
        // d = 7;   // <- 에러 int d 변수는 하위 괄호에서 선언되었다. 
        int d = 7;   // 하위에서 선언된 변수는 사용할 수 없으므로 다시 선언해야한다.

    }

    // "public" : 모든 곳에서 가져다 쓸수 있다. 
    // "static" : 객체생성을 하지 않아도 쓸수 있다. 
    // "int" : 함수를 실행하고 난 결과값의 자료형
    // "plus" : 메서드 명
    // "(int a, int b)" : 입력값, 각 입력값은 자료형 + 변수명 으로 표시하고
    //                     콤마(,) 로 구분한다.
    /* 
        "{
            int y = a + b;                 // a와 b를 더한 후 y에 저장.
            return y;                      // y 값을 결과값으로 처리한다.
        }" : 메서드가 처리해야할 코드
    */
    public static int plus(int i, int j) {
        int r = i + j;
        return r;
    }
}
