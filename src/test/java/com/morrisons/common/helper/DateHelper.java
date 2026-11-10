package com.morrisons.common.helper;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DateHelper {

    private static final Logger log = Logger.getLogger(DateHelper.class);

    public static String getCurrentDateAsHeader() {

        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEEE d MMM");
        String date = DATE_FORMAT.format(new Date());
        String currentDate = date;
        String[] a = currentDate.split(" ");
        String weekDay = (a[0]);
        String dd;
        int day = 0;
        day = Integer.parseInt(a[1]);
        if (day == 1 || day ==21 || day==31) {

            dd = (a[1] + "st");
        }
        else if (day ==2 || day==22)
        {
            dd = (a[1] + "nd");
        }
        else if (day==3 || day==23)
        {
            dd = (a[1] + "rd");
        }
        else {
            dd = (a[1] + "th");
        }
        String mon = (a[2]);
        String expected = (weekDay.concat(" " + dd).concat(" " + mon));
        System.out.println("Expected Date: " + expected);
        return expected;
    }

}
