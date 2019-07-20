package com.hisign.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/15.
 */
public class CommonUtils {

    public static Date strToDate(String patten, String str) {
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 日期转换成字符串（格式为“自定义”）
     *
     * @param date
     * @return str
     */
    public static String dateToStr(Date date, String formatString){
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        String str = format.format(date);
        return str;
    }
}
