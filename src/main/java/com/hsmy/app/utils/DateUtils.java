package com.hsmy.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * {@link Date} 解析、格式化的脚手架构工具类.
 *
 * @author devzzm
 */
public final class DateUtils {

    /**
     * 简单的日期格式： yyyy-MM-dd
     */
    public static final String PATTERN_SIMPLE_DATE = "yyyy-MM-dd";

    public static final Date parse(String source, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(source);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 判断指定的两个日期的所属的星期是否相同.
     *
     * @return 当两个日期相同时返回 <code>true</code>
     */
    public static boolean isSameWeekOfday(Date d1, Date d2) {
        Calendar d1Cal = Calendar.getInstance();
        d1Cal.setTime(d1);
        Calendar d2Cal = Calendar.getInstance();
        d2Cal.setTime(d2);
        return d1Cal.get(Calendar.DAY_OF_WEEK) == d2Cal.get(Calendar.DAY_OF_WEEK);
    }

}
