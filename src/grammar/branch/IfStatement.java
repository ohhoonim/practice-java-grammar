package grammar.branch;

public class IfStatement {
    public static void main(String[] args) {
        IO.println("if");

        boolean isWalk = true;
        // if 기본 사용법
        /*
            if (조건) {
                실행할 코드
            }
        */
        if (isWalk) {
            IO.println("도보로 배달");
        } else {
            IO.println("오토바이로 배달");
        }

        isWalk = false;
        boolean isTruck = true;

        // else if 사용
        if (isWalk) {
            IO.println("도보로 배달");
        } else if (isTruck) {
            IO.println("트럭으로 배달");
        } else {
            IO.println("오토바이로 배달");
        }

        // 논리 연산자 사용
        boolean a = true;
        boolean b = false;

        if ( a && b ) {
            IO.println("a와 b는 모두 true입니다.");
        } else {
            IO.println("a와 b 둘 중 적어도 하나는 false");
        }


    }
}
