package com.jsoft.testjavabasics.test1;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * This is Description
 *
 * @author jim
 * @date 2017/11/25
 */
public class TimeApp {
    public static void main(String[] args) {
        // Java 7及之前版本
        // 使用java.util.Calendar（不推荐）
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2015-09-17 20:27:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar now = Calendar.getInstance();
        now.setTime(date);

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1; // 0-based!
        int day = now.get(Calendar.DAY_OF_MONTH);

        System.out.println("year: " + year);
        System.out.println("month: " + month);
        System.out.println("day: " + day);

        // 时间已经改变，输出时间戳，可以看出这个是全局的，所以不建议使用全局的，直接使用时重新创建一个new SimpleDateFormat().getCalendar()
        System.out.println(now.getTimeInMillis());

        // joda-time（推荐），第三方库
        DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");
        LocalDate localDate = formatter.parseLocalDate("2015-09-17 20:27:00");

        System.out.println("yearOfCentury: " + localDate.getYearOfCentury());
        System.out.println("monthOfYear: " + localDate.getMonthOfYear());
        System.out.println("dayOfMonth: " + localDate.getDayOfMonth());
    }
}
