package std.optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalStreamMain {
    public static void main(String[] args) {
        List<User> users = List.of(
            new User(1L, "matthew", "matthew@email.dev", new Address("12345", "1223 Seounl chungjeonro St", "Apt 3 1")),
            new User(2L, "josh", "josh@email.com"),   // address 없음 
            new User(3L, "jim", "jim@email.co", new Address("12345", "1233 Seounl joonro St", "Apt 1 6")),
            new User(4L, "koy", "koy@email.net", new Address("12345", "12653 Kyeongju silla St", "Apt 7 1")),
            new User(5L, "safin", "safin@email.com", new Address("12345", "1233 Busan sasang St", "Apt 8 1")),
            new User(6L, "zordan", "zordan@email.kr", new Address("12345", "1293 Sejong Main centeral St", "Apt 9 1")),
            new User(7L, "peagu", "peagu@email.info", new Address("12345", "1023 Seounl beonji St", "Apt 2 1"))
        );

        
        users.stream()
            .map(User::getAddress)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .forEach(System.out::println);

        users.stream()
            .map(User::getAddress)
            .flatMap(Optional::stream)       // flatMap과 Optional.stream()을 사용하면 코드가 한줄로 줄어듦
            .forEach(System.out::println);

       
    }

    
}
