package com.stars.sea.work.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateUtil {
    /**
     * 根据给定的日期格式获取今天的日期
     * @param format
     * @return
     */
    public static String today(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        return sdf.format(date);
    }
    /**
     * 根据给定的日期格式获取历史的日期
     * 距离今天2-6年的日期，随机生成一个2-6岁的孩子生日
     * @param format
     * @return
     */
    public static String getHistoryDay(String format) {
        Random random1 = new Random(System.currentTimeMillis());
        int max = 2400;
        int min = 800;
        int index = (random1.nextInt(max) % (max - min + 1) + min)*-1;

        SimpleDateFormat df = new SimpleDateFormat(format);
        //取今天日期,如果日期类型为String类型,可以使用df.parse()方法,转换为Date类型
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();//new一个Calendar类,把Date放进去
        calendar.setTime(date);
        calendar.add(Calendar.DATE, index);//实现日期加一操作,也就是明天
        return df.format(calendar.getTime());

    }
    /**
     * 根据给定的日期和日期格式获取历史的日期
     * 随机生成一个从出生日期到今天之间的一个入园日期
     * @param format
     * @return
     */
    public static String getHistoryDay(String targetDate,String format) {
        if (StringUtils.isEmpty(targetDate)) {
            targetDate = "2018年08月08日";
        }
        SimpleDateFormat df = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();//new一个Calendar类,把Date放进去
        Date parse = new Date();
        try {
             parse = df.parse(targetDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(parse);
        long time1 = calendar.getTimeInMillis();
        Date date = new Date();
        calendar.setTime(date);
        long time2 = calendar.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        Random random1 = new Random(System.currentTimeMillis());
        int max = (int)between_days-1;
        int min = 1;
        int index = (random1.nextInt(max) % (max - min + 1) + min)*-1;

        //取今天日期,如果日期类型为String类型,可以使用df.parse()方法,转换为Date类型
        calendar.setTime(date);
        calendar.add(Calendar.DATE, index);//实现日期加一操作,也就是明天
        return df.format(calendar.getTime());

    }
}
