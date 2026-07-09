package std.implement;

public class PayMoney implements PayMethod {

    @Override
    public String pay() {
        return "money";
    }
    
    @Override
    public PayMethod changeMethod(PayMethod payMethod) {
        throw new RuntimeException("card로 지급을 변경할 수 없습니다.");
    }

}
