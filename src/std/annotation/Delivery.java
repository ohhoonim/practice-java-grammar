package std.annotation;


@CustomAnnotation
public class Delivery {
    String deliver;
    String receiver;
    // @CustomAnnotation  <<- 여기엔 붙일 수 없다. 생성자이다. ElementType.CONSTRUCTOR 필요
    public Delivery(String d, String r) {
        this.deliver = d;
        this.receiver = r;
    }
    @CustomAnnotation
    public String getDeliver() {
        return deliver;
    }
    public String getReceiver() {
        return receiver;
    }
}
