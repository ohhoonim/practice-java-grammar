package grammar.object;

public class Main {
    public static void main(String[] args) {
        
        // 새 차 샀다. 
        // 자동차는 처음 생산되면 차량번호, 차종, 연비에 대한 기본정보를 가지고 있다. 
        String carNumber ="123 가 3456";
        String carType = "카니발";
        double fuelEfficiency = 15.4;
        // 참조데이터형은 메모리에 등록을 해야 사용할 수 있고,  
        // 참조데이터형이 메모리에 등록된 상태를 인스턴스라고 한다.
        // "new"는 참조데이터형을 인스턴스로 만드는 연산자이다.
        Car myCar = new Car(carNumber, carType, fuelEfficiency);

        // 차종은 개조하면 나중에 변경가능하다. 
        myCar.setCarType("캠핑카");
        
        // 오늘은 바람좀 쐬러 드라이브나 가야겠다. 
        // 출발전에 기름이 얼마나 있는지 체크하고 드라이브 시작
        double startOil = 100.4;
        myCar.drive(startOil);

        // 잘 놀다왔다. 남은 기름 얼마인지 체크보면 주행거리가 
        // 얼마인지 알 수 있겠지
        double distanceDriven = myCar.stop(95.1);
        IO.println("나들이 주행거리: " + distanceDriven); // 음..80km쯤 돌아다녔군.

        // 부서 워크샵 가는데 내차를 쓰자고 한다. 젠장 ㅠㅠ
        // 기름 체크하고 출발하자
        myCar.drive(89.7);

        // 피곤하다 기름 체크하고 회사에 영수증 청구할 거리나 찍어두자
        distanceDriven = myCar.stop(81.3);
        IO.println("워크샵 주행거리: " + distanceDriven);

        // 차 팔아야겠다. 중고시장에 올릴려면 총 주행거리 기록이 필요해
        double totalDistanceDriven =  myCar.getTotalDistanceDriven();
        IO.println("총 주행거리: " + totalDistanceDriven);

        // 주행거리가 너무 많이 나오는데...조작해야겠다. 
        myCar.operateManuallyTotalDistance(100);
        // 조작 결과를 보자
        totalDistanceDriven =  myCar.getTotalDistanceDriven();
        IO.println("조작 후 총 주행거리: " + totalDistanceDriven);

    }
}
