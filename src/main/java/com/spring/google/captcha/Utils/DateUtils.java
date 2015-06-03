package com.spring.google.captcha.Utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author ajay
 */
public class DateUtils implements Constants {

    public static String getCurrentTime() {

        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(DATE_FORMAT);
        return dateTime.toString(dateTimeFormatter);
    }
}
