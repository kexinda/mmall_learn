package com.mmall.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * Created by kexi955 on 5/5/2024.
 */
public class DateTimeUtil {
    //joda-time
    //str -> data
    //data -> str
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";


    public static Date str2Date(String dateTimestr, String formatStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimestr);
        return dateTime.toDate();
    }

    public static String date2Str(Date date, String formatStr){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    public static Date str2Date(String dateTimestr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimestr);
        return dateTime.toDate();
    }

    public static String date2Str(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }

    public static void main(String[] args) {
        System.out.println(DateTimeUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateTimeUtil.str2Date("2010-10-01 11:11:11","yyyy-MM-dd HH:mm:ss"));
    }

}
