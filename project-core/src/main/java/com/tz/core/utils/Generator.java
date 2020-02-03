package com.tz.core.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * ID工具类
 * @author KyrieCao
 * @date 2020/2/3 22:24
 */
public class Generator {

    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("YYYYMMddHHmmss");

    /**
     * 生成异常ID
     * @return String
     * @author KyrieCao
     * @date 2020/2/3 22:24
     */
    public static String genExceptionId(){
        return "" + RandomStringUtils.randomNumeric(6);
    }

    /**
     * 生成结果组ID
     * @return String
     * @author KyrieCao
     * @date 2020/2/3 22:24
     */
    public static String genResultGroupId(){
        Calendar calendar = Calendar.getInstance();
        String prefix = String.valueOf(calendar.get(Calendar.YEAR)).substring(2) + (calendar.get(Calendar.MONTH) + 1) + calendar.get(Calendar.DAY_OF_MONTH) + calendar.get(Calendar.HOUR_OF_DAY);
        return prefix + RandomStringUtils.randomNumeric(6);
    }

    /**
     * 生成模块版本号
     * @return String
     * @author KyrieCao
     * @date 2020/2/3 22:25
     */
    public static String genVersionNo() {
        return RandomStringUtils.randomAlphanumeric(20);
    }
}
