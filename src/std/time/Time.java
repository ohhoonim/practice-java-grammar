package std.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Time {
    public static void main(String[] args) {
        // LocalDate : 날짜만 출력
        LocalDate current = LocalDate.now();
        IO.println(current);
        LocalDate birthday = LocalDate.of(1976, 7, 29);
        IO.println(birthday);

        // LocalDateTime
        // 시스템 zone 정보가 이미 반영되어있다. 
        IO.println(LocalDateTime.now());
        // ZonedDateTime
        IO.println(ZonedDateTime.now(ZoneId.of("+00:00")));
        IO.println(ZonedDateTime.now(ZoneId.of("-01:00")));
        IO.println(ZonedDateTime.now(ZoneId.of("+09:00")));

        // Instant
        IO.println(Instant.now());
        IO.println(Instant.now().atZone(ZoneId.of("+09:00")));
        IO.println(Instant.now().atOffset(ZoneOffset.of("+09:00")));

    }
}
