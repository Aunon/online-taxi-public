package com.aunon.internalcommon.utils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/11/14/20:01
 * @Description:
 */
public class SsePrefixUtils {

    public static  final String sperator = "$";

    public  static String generatorSseKey(Long userId , String identity){
        return userId+sperator+identity;
    }
}
