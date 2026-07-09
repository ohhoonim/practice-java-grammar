package std.implement;

public class PayCard implements PayMethod {

    @Override
    public String pay() {
        return "card";
    }

}
