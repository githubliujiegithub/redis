package com.example.redis.study.jwt;

import java.util.Calendar;
import java.util.Date;

public class FailureTimeUtils {

    public static Date createValidTime(FailureTime failureTime, int jwtValidTime) {
        Date date = new Date();
        if (failureTime.name().equals(FailureTime.SECOND)) {
            return createBySecond(date, jwtValidTime);
        }
        if (failureTime.name().equals(FailureTime.MINUTE)) {
            return createBySecond(date, jwtValidTime * 60);
        }
        if (failureTime.name().equals(FailureTime.HOUR)) {
            return createBySecond(date, jwtValidTime * 60 * 60);
        }
        if (failureTime.name().equals(FailureTime.DAY)) {
            return getDateAfter(date, jwtValidTime);
        }
        return null;
    }

    private static Date getDateAfter(Date date, int jwtValidTime) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, calendar.get(Calendar.DATE) + jwtValidTime);
        return calendar.getTime();

    }

    private static Date createBySecond(Date date, int jwtValidTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, jwtValidTime);
        return calendar.getTime();
    }
}
