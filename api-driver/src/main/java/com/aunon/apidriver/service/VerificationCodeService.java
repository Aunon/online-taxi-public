package com.aunon.apidriver.service;

import com.aunon.apidriver.remote.ServiceDriverUserClient;
import com.aunon.apidriver.remote.ServiceVerificationcodeClient;
import com.aunon.internalcommon.constant.CommonStatusEnum;
import com.aunon.internalcommon.constant.DriverCarConstants;
import com.aunon.internalcommon.constant.IdentityConstants;
import com.aunon.internalcommon.constant.TokenConstants;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.requsest.VerificationCodeDTO;
import com.aunon.internalcommon.response.DriverUserExistsResponse;
import com.aunon.internalcommon.response.NumberCodeResponse;
import com.aunon.internalcommon.response.TokenResponse;
import com.aunon.internalcommon.utils.JwtUtils;
import com.aunon.internalcommon.utils.RedisPrefixUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/27/12:51
 * @Description:
 */
@Service
@Slf4j
public class VerificationCodeService {
    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    @Autowired
    private ServiceVerificationcodeClient serviceVerificationcodeClient;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public ResponseResult checkAndSendVerificationCode(String driverPhone){
        //查询 service-driver-user,该手机号的司机是否存在
        ResponseResult<DriverUserExistsResponse> driverUserExistsResponseResponseResult = serviceDriverUserClient.checkDriver(driverPhone);
        DriverUserExistsResponse data = driverUserExistsResponseResponseResult.getData();
        int ifExists = data.getIfExists();
        if(ifExists == DriverCarConstants.DRIVER_NOT_EXISTS){
            return ResponseResult.fail(CommonStatusEnum.DRIVER_NOT_EXISTS.getCode(),CommonStatusEnum.DRIVER_NOT_EXISTS.getValue());
        }
        log.info(driverPhone + "的司机存在");

        //获取验证码
        ResponseResult<NumberCodeResponse> numberCodeResult = serviceVerificationcodeClient.getNumberCode(6);
        NumberCodeResponse numberCodeResponse = numberCodeResult.getData();
        int numberCode = numberCodeResponse.getNumberCode();
        log.info("验证码"+numberCode);

        //调用第三方发送验证码

        //存入redis
        String key = RedisPrefixUtils.generatorKeyByPhone(driverPhone, IdentityConstants.DRIVER_IDENTITY);
        stringRedisTemplate.opsForValue().set(key,numberCode+"",2, TimeUnit.MINUTES);


        return ResponseResult.success("");
    }

    public ResponseResult checkCode(String driverPhone,String verificationCode){
        String key = RedisPrefixUtils.generatorKeyByPhone(driverPhone,IdentityConstants.DRIVER_IDENTITY);
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


        //生成token
        String accessToken = JwtUtils.generatorToken(driverPhone, IdentityConstants.DRIVER_IDENTITY, TokenConstants.ACCESS_TOKEN_TYPE);
        String refreshToken = JwtUtils.generatorToken(driverPhone,IdentityConstants.DRIVER_IDENTITY,TokenConstants.REFRESH_TOKEN_TYPE);

        //将token存入redis
        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(driverPhone, IdentityConstants.DRIVER_IDENTITY,TokenConstants.ACCESS_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(accessTokenKey,accessToken,30,TimeUnit.DAYS);

        String refreshTokenKey = RedisPrefixUtils.generatorTokenKey(driverPhone, IdentityConstants.DRIVER_IDENTITY,TokenConstants.REFRESH_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(refreshTokenKey,refreshToken,31,TimeUnit.DAYS);

        //响应
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessToken);
        tokenResponse.setRefreshToken(refreshToken);
        return ResponseResult.success(tokenResponse);
    }
}
