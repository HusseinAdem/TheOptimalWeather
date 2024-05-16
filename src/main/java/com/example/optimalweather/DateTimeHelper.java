package com.example.optimalweather;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeHelper {

    public static boolean compareDateTimeStrings(String isoDateTime) {
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime customLocalDateTime = LocalDateTime.parse(getFormattedTime(), customFormatter);

        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_DATE_TIME;
        ZonedDateTime isoZonedDateTime = ZonedDateTime.parse(isoDateTime, isoFormatter);

        LocalDateTime isoLocalDateTime = isoZonedDateTime.toLocalDateTime();
        System.out.println("tideen" + customLocalDateTime);
        return customLocalDateTime.equals(isoLocalDateTime);
    }

    public static LocalDateTime getCurrentTimePlus24h(){
        LocalDateTime currentTime = LocalDateTime.now();

        int minutes = currentTime.getMinute();
        LocalDateTime roundedTime;
        if (minutes >= 30) {
            roundedTime = currentTime.withMinute(0).withSecond(0).plusHours(1);
        } else {
            roundedTime = currentTime.withMinute(0).withSecond(0);
        }
        return roundedTime.plusHours(24);
    }

    public static String getFormattedTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return getCurrentTimePlus24h().format(formatter);
    }
}
