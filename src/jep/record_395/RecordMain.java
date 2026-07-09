package jep.record_395;

import java.util.ArrayList;
import java.util.List;

public class RecordMain {
    public static void main(String[] args) {
        // record는 정말 immutable 할까?
        List<String> buckets = new ArrayList<>();
        buckets.add("bucket1");
        buckets.add("bucket2");
        buckets.add("bucket3");
        // List<String> buckets = List.of("bucket1","bucket2","bucket3");
        var user = new User("matthew", buckets);

        buckets.add("bucket1000");
        
        // record자체는 immutable 하겠지만 필드는 mutable 할 수도 있다
        IO.println(user);
    }

    record User(String name, List<String> buckets) {}
}
