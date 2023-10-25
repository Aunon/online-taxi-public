package com.aunon.internalCommon.utils;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/24/22:14
 * @Description:
 */
public class BigDecimalUtils {
    /**
     * 加法
     * @param v1
     * @param v2
     * @return
     */
    public static double add(double v1,double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }

    public static double subtract(double v1,double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }

    public static double multiply(double v1,double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.multiply(b2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 除法
     * @param v1
     * @param v2
     * @return
     */
    public static double divide(double v1,double v2){
        if(v2<=0 || v1<0){
            throw new IllegalArgumentException("除数非法");
        }
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2,2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
