package org.example.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class LocalDateTimeTest {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {

        LocalDateTime beforeMonth = LocalDateTime.of(2023, 5, 13, 00, 00, 00);
        LocalDateTime before = LocalDateTime.of(2023, 6, 13, 00, 00, 00);
        LocalDateTime before7Days = LocalDateTime.now().minus(7, ChronoUnit.DAYS);

        System.out.println("beforeMonth: " + beforeMonth.isBefore(before7Days));
        System.out.println("before in 7days:" + before.isBefore(before7Days));

        LocalDateTime parsedDateTime = LocalDateTime.parse("2023-06-19 07:00:00", formatter);
        System.out.println(parsedDateTime);
    }


}
