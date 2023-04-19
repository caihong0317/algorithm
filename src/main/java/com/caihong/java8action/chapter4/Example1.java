package com.caihong.java8action.chapter4;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.HashMap;

public class Example1 {
    public static void main(String[] args) {
/*
        Date deadLine;
        deadLine=null;
        deadLine.toString(); // 未初始化时无法编译
*/

        LocalDate now = LocalDate.now();
        int year = now.getYear();
        Month month = now.getMonth();
        int monthValue = now.getMonthValue();
        int dayOfYear = now.getDayOfYear();
        int dayOfMonth = now.getDayOfMonth();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        LocalDate after = now.plusDays(200);
/*
        System.out.println(now);
        System.out.println(year + " " + monthValue + " " + dayOfMonth);
        System.out.println(after);
*/

/*
        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        LocalDate date1 = LocalDate.parse("2014-03-18");
        LocalTime time1 = LocalTime.parse("13:45:20");

        Period tenDays = Period.between(LocalDate.of(2014, 3, 8),
            LocalDate.of(2014, 3, 18));
        int days = tenDays.getDays();
        int months = tenDays.getMonths();
        System.out.println(days+" "+months); // 10 0

        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes1 = Duration.of(3, ChronoUnit.MINUTES);
        Period tenDays1 = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
*/

        LocalDate date = LocalDate.of(2014, 3, 18);
        date = date.with(ChronoField.MONTH_OF_YEAR, 9);
        date = date.plusYears(2).minusDays(10);
        date.withYear(2011);
        String format = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(format);
        HashMap<String, String> map = new HashMap<>();
    }
}
