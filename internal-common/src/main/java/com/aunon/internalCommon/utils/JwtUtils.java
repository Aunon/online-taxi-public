package com.aunon.internalCommon.utils;

import com.aunon.internalCommon.dto.TokenResult;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
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

    private static final String JWT_KEY_Phone = "phone";

    private static final String JWT_KEY_IDENTITY="identity";

    private static final String JWT_TOKEN_TYPE="tokenType";

    private static final String JWT_TOKEN_TIME="tokenTime";

    //生成token
    public static String generatorToken(String passengerPhone,String identity,String tokenType){
        Map<String,String> map = new HashMap<>();
        map.put(JWT_KEY_Phone,passengerPhone);
        map.put(JWT_KEY_IDENTITY,identity);
        map.put(JWT_TOKEN_TYPE,tokenType);

        //token过期时间
        //Calendar calendar = Calendar.getInstance();
        //calendar.add(Calendar.DATE,1);
        //Date date = calendar.getTime();

        //防止每次生成的token都一样
        map.put(JWT_TOKEN_TIME,Calendar.getInstance().getTime().toString());

        JWTCreator.Builder builder = JWT.create();

        map.forEach(
                (k,v)->{
                    builder.withClaim(k,v);
                }
        );

        //builder.withExpiresAt(date);

        String sign = builder.sign(Algorithm.HMAC256(SIGN));

        return sign;
    }

    //解析token
    public static TokenResult parseToken(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        TokenResult tokenResult = new TokenResult();
        tokenResult.setPhone(verify.getClaim(JWT_KEY_Phone).asString());
        tokenResult.setIdentity(verify.getClaim(JWT_KEY_IDENTITY).asString());
        return tokenResult;
    }

    public static TokenResult checkToken(String token){
        TokenResult tokenResult = null;
        try {
            tokenResult = JwtUtils.parseToken(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tokenResult;
    }

    public static void main(String[] args) {
        String s = generatorToken("13242521037","1","accessToken");
        System.out.println("token:"+s);
        System.out.println("解析后的token:-----------------");
        TokenResult tokenResult = parseToken(s);
        System.out.println("phone:"+tokenResult.getPhone());
        System.out.println("identity;"+tokenResult.getIdentity());
    }
}
