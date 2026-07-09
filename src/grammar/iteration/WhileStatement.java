package grammar.iteration;

public class WhileStatement {
    public static void main(String[] args) {

        int x = 0;
        int y = 10;

        // 1. 조건이 참인 동안 계속 실행된다.
        while( x > y ) {
            IO.println("x값: " + x );
            x++;
        }

        // 2. 최소 한번은 실행되게 하려면 do ~ while 사용
        do {
            IO.println("x값: " + x );
            x++;
        } while (x > y);

        // 3. 아래처럼 코딩하면 프로그램이 영원히 멈추지 않음.
        // 강제종료 단축키 ctrl + c 
        
        // while(true) {
        //     IO.println(x++);
        // }
    }
}
