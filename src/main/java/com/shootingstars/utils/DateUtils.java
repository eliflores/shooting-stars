package com.shootingstars.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtils {
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static DateTime fromDateString(String dateString) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_PATTERN);
        return formatter.parseDateTime(dateString);
    }

    public static DateTime fromDateStringWithTime(String dateString) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_TIME_PATTERN);
        return formatter.parseDateTime(dateString);
    }

    public static String formatDate(DateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_PATTERN);
        return formatter.print(dateTime);
    }
}
