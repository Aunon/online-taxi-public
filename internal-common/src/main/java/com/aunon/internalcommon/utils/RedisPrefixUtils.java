package com.aunon.internalcommon.utils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/23/18:49
 * @Description:
 */
public class RedisPrefixUtils {
    //乘客验证码前缀
    public static String verificationCodePrefix = "verification-code-";

    //token存储的前缀
    public static String tokenPrefix = "token-";

    // 黑名单设备号
    public static String blackDeviceCodePrefix = "black-device-";

    /**
     * 根据手机号,生成Key
     * @param phone
     * @param identity
     * @return
     */
    public static String generatorKeyByPhone(String phone,String identity){

        return verificationCodePrefix+identity+"-"+phone;
    }

    /**
     * 生成TokenKey
     * @param phone
     * @param identity
     * @return
     */
    public static String generatorTokenKey(String phone, String identity,String tokenType){
        return tokenPrefix + phone + "-" + identity + "-" + tokenType;
    }
}
