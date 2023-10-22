package com.aunon.apipassenger.service;

import com.aunon.apipassenger.remote.ServiceVerificationcodeClient;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.NumberCodeResponse;
import com.aunon.internalcommon.response.TokenResponse;
import net.sf.json.JSONObject;
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

    //乘客验证码前缀
    private String verificationCodePrefix = "passenger-verification-code-";

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

        String key = verificationCodePrefix+passengerPhone;
        //存入redis
        stringRedisTemplate.opsForValue().set(key,numberCode+"",2, TimeUnit.MINUTES);


        return ResponseResult.success();
    }

    /**
     * 校验验证码
     */
    public ResponseResult checkCode(String passengerPhone,String verificationCode){
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken("token value");
        return ResponseResult.success(tokenResponse);
    }

}
