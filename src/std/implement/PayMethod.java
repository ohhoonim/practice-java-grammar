package std.implement;

public interface PayMethod {

    public default PayMethod changeMethod(PayMethod payMethod) {
        return payMethod;
    };

    public String pay(); 

}
