package com.lagoru.forex.data.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lagoru on 29.08.16.
 */
public class DateUtils {
    final public static SimpleDateFormat investingComDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    final public static SimpleDateFormat hourAndMinute = new SimpleDateFormat("HH:mm");

    public static Date parseDate(String dateString, SimpleDateFormat format) throws ParseException {
        return format.parse(dateString);
    }
}

