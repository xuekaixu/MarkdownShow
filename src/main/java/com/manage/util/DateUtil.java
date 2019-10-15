package com.manage.util;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil
{
    public static final String YYYYMMDD = "yyyy/MM/dd";
    public static final String YYYYMMDD2 = "yyyy-MM-dd";
    public static final String YYYYMMDDHHMISS = "yyyyMMddHHmmss";
    public static final String YYYYMMDDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String HHMM = "HH:mm";
    public static final String YYYYMM_CN = "yyyy年MM月";
    private static Calendar calendar = Calendar.getInstance();


    public static String parseDateToStr(Date time, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(time);
    }

    public static Date parseStrToDate(String dateStr, String format) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.parse(dateStr);
    }



    public static String parseTimestampToStr(Timestamp timestamp, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(timestamp);
    }

    public static Date getBeforeDate(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(5, day);
        return cal.getTime();
    }

    public static Date getBeforeMonth(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(2, month);
        return cal.getTime();
    }


    public static String parseDateToYM(String dateStr, String format) throws ParseException { return parseDateToStr(parseStrToDate(dateStr, format), "yyyy���MM���"); }


    public static String parseDateToQuarter(String dateStr, String format) throws ParseException {
        calendar.setTime(parseStrToDate(dateStr, format));
        int year = calendar.get(1);
        int month = calendar.get(2) + 1;

        int quarter = 0;
        if (month >= 1 && month <= 3) {
            quarter = 1;
        } else if (month >= 4 && month <= 6) {
            quarter = 2;
        } else if (month >= 7 && month <= 9) {
            quarter = 3;
        } else {
            quarter = 4;
        }
        return year + "Q" + quarter;
    }

    public static void main(String[] args) {
        System.out.println(getBeforeDate(new Date(), -3));
        System.out.println(parseDateToStr(new Date(), "yyyy年MM月"));
        try {
            System.out.println(parseDateToQuarter("2019/03/30", "yyyy/MM/dd"));
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

