package com.aunon.apiPassenger.service;

import com.aunon.apiPassenger.remote.ServicePassengerUserClient;
import com.aunon.apiPassenger.remote.ServiceVerificationcodeClient;
import com.aunon.internalCommon.constant.CommonStatusEnum;
import com.aunon.internalCommon.constant.IdentityConstants;
import com.aunon.internalCommon.constant.TokenConstants;
import com.aunon.internalCommon.dto.ResponseResult;
import com.aunon.internalCommon.requsest.VerificationCodeDTO;
import com.aunon.internalCommon.response.NumberCodeResponse;
import com.aunon.internalCommon.response.TokenResponse;
import com.aunon.internalCommon.utils.JwtUtils;
import com.aunon.internalCommon.utils.RedisPrefixUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/21/16:11
 * @Description:
 */
@Service
public class VerificationCodeService {
    @Autowired
    private ServiceVerificationcodeClient serviceVerificationcodeClient;

    @Autowired
    private ServicePassengerUserClient servicePassengerUserClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 生成验证码
     * @param passengerPhone
     * @return
     */
    public ResponseResult generatorCode(String passengerPhone){

        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();

        String key = RedisPrefixUtils.generatorKeyByPhone(passengerPhone);
        //存入redis
        stringRedisTemplate.opsForValue().set(key,numberCode+"",2, TimeUnit.MINUTES);


        return ResponseResult.success();
    }

    /**
     * 校验验证码
     */
    public ResponseResult checkCode(String passengerPhone,String verificationCode){
        String key = RedisPrefixUtils.generatorKeyByPhone(passengerPhone);
        //根据手机号获取redis中的验证码
        String codeRedis = stringRedisTemplate.opsForValue().get(key);

        System.out.println("redis中的验证码："+codeRedis);

        //校验验证码
        if(StringUtils.isBlank(codeRedis)){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
        if(!verificationCode.trim().equals(codeRedis.trim())){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }

        //判断原来是否有用户，并处理
        VerificationCodeDTO verificationCodeDTO = new VerificationCodeDTO();
        verificationCodeDTO.setPassengerPhone(passengerPhone);
        servicePassengerUserClient.loginOrRegister(verificationCodeDTO);

        //生成token
        String accessToken = JwtUtils.generatorToken(passengerPhone, IdentityConstants.PASSENGER_IDENTITY, TokenConstants.ACCESS_TOKEN_TYPE);
        String refreshToken = JwtUtils.generatorToken(passengerPhone,IdentityConstants.PASSENGER_IDENTITY,TokenConstants.REFRESH_TOKEN_TYPE);

        //将token存入redis
        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(passengerPhone, IdentityConstants.PASSENGER_IDENTITY,TokenConstants.ACCESS_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(accessTokenKey,accessToken,30,TimeUnit.DAYS);

        String refreshTokenKey = RedisPrefixUtils.generatorTokenKey(passengerPhone, IdentityConstants.PASSENGER_IDENTITY,TokenConstants.REFRESH_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(refreshTokenKey,refreshToken,31,TimeUnit.DAYS);

        //响应
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessToken);
        tokenResponse.setRefreshToken(refreshToken);
        return ResponseResult.success(tokenResponse);
    }

}
