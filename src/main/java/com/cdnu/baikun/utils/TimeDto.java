package com.cdnu.baikun.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 格式化时间
 * @author 白坤
 * @date 2021/8/6
 */
public class TimeDto {
    private Date date;

    public static String getTime(Date date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static String getDate(Date date) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
