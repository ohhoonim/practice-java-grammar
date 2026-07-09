package grammar.object;

public class Car {
    // 필드
    //     접근한정자 + 데이터타입 + 필드명
    // 변수선언하는 것과 비슷해보이지만 '접근한정자'라는 것이 존재한다.
    // 그외에 final, static 같은 것들이 더 추가될 수 있지만 자세한건 
    // 나중에 공부해도 늦지 않는다.
    private String carNumber;           // 차번호
    private String carType;             // 차종 
    private double fuelEfficiency ;     // 연비
    private double startOil;            // 주행시작시 연료량
    private double endOil;              // 주행종료시 연료량
    private double totalDistanceDriven ;      // 총 주행거리

    // 생성자 
    // 생성자는 class 명과 동일한 메서드의 일종이다.
    // new 연산자를 이용하여 인스턴스화할 때 사용한다.
    public Car(String carNumber, String carType, double fuelEfficiency) {
        this.carNumber = carNumber;
        this.carType = carType;
        this.fuelEfficiency = fuelEfficiency;
    }

    // 메서드
    //       접근한정자 + 데이터타입 + 필드명
    // 결과값을 주지않는 메서드는 데이터타입을 "void" 라고 지정해주면 된다. 

    public void drive(double startOil) {
        this.startOil = startOil;
    }

    public double stop(double endOil) {
        this.endOil = endOil;
        double consumedOil = this.startOil - this.endOil;
        this.totalDistanceDriven = this.totalDistanceDriven + (consumedOil * fuelEfficiency);
        return consumedOil * fuelEfficiency;
    }

    public String getCarNumber() {
        return this.carNumber;
    }

    public void setCarType(String type) {
        this.carType = type;
    }

    public String getCarType() {
        return this.carType;
    }

    public double getFuelEfficiency() {
        return this.fuelEfficiency;
    }

    public double getTotalDistanceDriven() {
        return this.totalDistanceDriven;
    }

    public void operateManuallyTotalDistance(double totalDistanceDriven) {
        this.totalDistanceDriven = totalDistanceDriven;
    }

}
