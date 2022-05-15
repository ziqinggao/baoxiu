package com.spb.houqin.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {

    public static Integer getDay(String startTime,String endTime) {
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(startTime));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(endTime));
            long time2 = cal.getTimeInMillis();
            long between_days=(time2-time1)/(1000*3600*24);

            return Integer.parseInt(String.valueOf(between_days));
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static Date getDateByStr(String time){
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(time);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
