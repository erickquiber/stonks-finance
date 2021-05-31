package com.acme.stonks.util;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CompoundInterest{

    public static long daysDifference(Date start, Date end){
        TimeUnit timeUnit = TimeUnit.DAYS;
        long diff = end.getTime()-start.getTime();
        return timeUnit.convert(diff, TimeUnit.MILLISECONDS);
    }

    public static Date addDaysToDate(Date start, int days){
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        c.add(Calendar.DATE, days);
        return c.getTime();
    }

    public static double teaToTem(double tea){
        return (double)(Math.pow(1+tea, (30f/360))) - 1; 
    }

    public static double futureValue(double capital, double tem){
        return capital*(1+tem);
    }
}
