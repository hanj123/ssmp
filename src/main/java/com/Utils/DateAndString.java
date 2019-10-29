package com.Utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateAndString {

    public static String dateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY/MM/DD-hh:mm:ss");
        String dateStr = formatter.format(date);
        return dateStr;
    }

    public static Date stringToDate(String dateStr){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(dateStr, pos);
        return strtodate;
    }
}
