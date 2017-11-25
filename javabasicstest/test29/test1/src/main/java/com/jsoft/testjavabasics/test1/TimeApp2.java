package com.jsoft.testjavabasics.test1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This is Description
 *
 * @author jim
 * @date 2017/11/25
 */
public class TimeApp2 {
    public static void main(String[] args) {
        // Java 8，直接使用new datetime api （推荐！！）
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse("2015-09-17 20:27:00", formatter);

        System.out.println("Year: " + ldt.getYear());
        System.out.println("Month: " + ldt.getMonth().getValue());
        System.out.println("DayOfMonth: " + ldt.getDayOfMonth());
    }
}
