/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * @ClassName: DateTest
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/3/25 11:20 AM
 * @Version: 1.0
 */
public class DateTest {

    /**
     * Date class
     */
    @Test
    public void testDate() {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
    }

    /**
     * Calendar abstract class
     */
    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
    }

    /**
     * SimpleDateFormat class
     * @throws ParseException
     */
    @Test
    public void testDateFormat() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str1 = "2019-03-25 11:58:32";
        long time = 1553424875;
        Date date = new Date(time * 1000);
        String str2 = simpleDateFormat.format(date);
        System.out.println(simpleDateFormat.parse(str1));
        System.out.println(str2);
    }

    /**
     * LocalDateTime
     */
    @Test
    public void testDateTimeBasic() {
        // get the time
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
        System.out.println(ldt.getNano());
        // date to timestamp
        long timestamp = ldt.toInstant(ZoneOffset.of("+08")).toEpochMilli();
        System.out.println(timestamp);
        // assign the time
        LocalDateTime ldt2 = LocalDateTime.of(2019, 3, 25, 15, 34, 36);
        System.out.println(ldt2);
        // plus the time
        LocalDateTime ldt3 = ldt2.plusYears(20);
        System.out.println(ldt3);
        LocalDateTime ldt4 = ldt2.minusYears(2);
        System.out.println(ldt4);
    }

    @Test
    public void testTemporalAdjuster() {
        // get the time
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        // modify the time
        LocalDateTime ldt2 = ldt.withDayOfMonth(4);
        System.out.println(ldt2);
        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(ldt3);
        // 自定义时间：下一个工作日
        LocalDateTime ldt5 = ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dow = ldt4.getDayOfWeek();
            if(dow.equals(DayOfWeek.FRIDAY)){
                return ldt4.plusDays(3);
            }else if(dow.equals(DayOfWeek.SATURDAY)){
                return ldt4.plusDays(2);
            }else{
                return ldt4.plusDays(1);
            }
        });
        System.out.println(ldt5);
    }

    /**
     * jdk 1.8 LocalDate
     */
    @Test
    public void testNewDate() {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate firstDay = LocalDate.of(2019, Month.JANUARY, 1);
        System.out.println(firstDay);
        LocalDate todayAsia = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(todayAsia);
        LocalDate ofEpochDay = LocalDate.ofEpochDay(365);
        System.out.println(ofEpochDay);
        LocalDate ofYearDay = LocalDate.ofYearDay(2019, 100);
        System.out.println(ofYearDay);
    }

    @Test
    public void testTime() {
        LocalTime now = LocalTime.now();
        System.out.println(now);
        LocalTime setTime =LocalTime.of(12, 20, 45, 20);
        System.out.println(setTime);
        LocalTime timeOfAsia = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(timeOfAsia);
        LocalTime ofSecondOfDay = LocalTime.ofSecondOfDay(7200);
        System.out.println(ofSecondOfDay);

    }

}
