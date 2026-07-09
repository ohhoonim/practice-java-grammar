package grammar.branch;

public class SwitchStatement {
    public static void main(String[] args) {
        IO.println("switch");
        
        // 방금전의 if문 
        boolean isWalk = false;
        boolean isTruck = true;

        if (isWalk) {
            IO.println("도보로 배달");
        } else if (isTruck) {
            IO.println("트럭으로 배달");
        } else {
            IO.println("오토바이로 배달");
        }

        // switch 기본 사용법
        /*
            switch (케이스) {
                case "케이스A":
                    실행할 코드
                case "케이스B":
                    실행할 코드
                default:
                    맞는 케이스가 없는 경우 실행할 코드
            }
         */
        String deliveryType = "트럭";
        switch(deliveryType) {
            case "도보":
                IO.println("도보로 배달");
                break;
            case "트럭":
                IO.println("트럭으로 배달");
                break;
            default:
                IO.println("오토바이로 배달");
        } 
    }
}
