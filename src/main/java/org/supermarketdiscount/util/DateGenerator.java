package org.supermarketdiscount.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateGenerator {
    /**
     * 将yyyy-MM-dd HH:mm:ss形式的字符串时间改为Date时间
     *
     * @param datetime
     * @return
     * @throws ParseException
     */
    public static Date getDatetime(String datetime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date result = df.parse(datetime);
        return result;
    }

    /**
     * 将yyyy-MM-dd形式的字符串时间改为Date时间
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getDate(String date) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date result = df.parse(date);
        return result;
    }

    /**
     * 将传入时间改为yyyy-MM-dd形式的Date时间
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date toDate(Date date) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.parse(df.format(date));
    }

    /**
     * 一般用不上，系统生成时间即为这个形式。
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date toDatetime(Date date) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.parse(df.format(date));
    }

    /**
     * 只保留Date的年和月
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date yearAndMouth(Date date) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
        return df.parse(df.format(date));
    }

    /**
     * 得到几天前的日期
     *
     * @param d   当前时间
     * @param day 需要提前的时间
     * @return 几天前的时间
     */
    public static Date getDateBefore(Date d, Integer day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }
}
