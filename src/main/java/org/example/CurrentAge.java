package org.example;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CurrentAge {
    public static int getCurrentAge(Date birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null");
        }
        Calendar currentCalendar = new GregorianCalendar();
        Calendar birthCalendar = new GregorianCalendar();
        birthCalendar.setTime(birthDate);
        int age = currentCalendar.get(1) - birthCalendar.get(1);

        if (currentCalendar.before(birthCalendar)) {
            age--;
        }

        return age;
    }
    //  https://currentmillis.com/   - convert milliseconds to Date for constructor
    public static void main(String[] args) {
        Date date = new Date(946677600000L);// 2000.01.01
        int currentAge = CurrentAge.getCurrentAge(date);
        System.out.println(date); //Sat Jan 01 00:00:00 EET 2000
        System.out.println(currentAge); // 24
    }
}