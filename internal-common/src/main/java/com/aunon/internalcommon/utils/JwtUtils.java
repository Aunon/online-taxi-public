package com.aunon.internalcommon.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/22/19:01
 * @Description:
 */
public class JwtUtils {
    //盐
    private static final String SIGN = "kajfis(#*";

    //生成token
    public static String generatorToken(Map<String,String> map){
        //token过期时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        Date date = calendar.getTime();

        JWTCreator.Builder builder = JWT.create();

        map.forEach(
                (k,v)->{
                    builder.withClaim(k,v);
                }
        );

        builder.withExpiresAt(date);

        String sign = builder.sign(Algorithm.HMAC256(SIGN));

        return sign;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age","14");
        String s = generatorToken(map);
        System.out.println("token:"+s);
    }
}
