package com.aunon.apipassenger.service;

import com.aunon.apipassenger.remote.ServicePassengerUserClient;
import com.aunon.apipassenger.remote.ServiceVerificationcodeClient;
import com.aunon.internalcommon.constant.CommonStatusEnum;
import com.aunon.internalcommon.constant.IdentityConstant;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.requsest.VerificationCodeDTO;
import com.aunon.internalcommon.response.NumberCodeResponse;
import com.aunon.internalcommon.response.TokenResponse;
import com.aunon.internalcommon.utils.JwtUtils;
import io.netty.util.internal.StringUtil;
import net.sf.json.JSONObject;
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

    //乘客验证码前缀
    private String verificationCodePrefix = "passenger-verification-code-";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 根据手机号,生成Key
     * @param passengerPhone
     * @return
     */
    public String generateKeyByPhone(String passengerPhone){
        return verificationCodePrefix+passengerPhone;
    }

    /**
     * 生成验证码
     * @param passengerPhone
     * @return
     */
    public ResponseResult generatorCode(String passengerPhone){

        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();

        String key = generateKeyByPhone(passengerPhone);
        //存入redis
        stringRedisTemplate.opsForValue().set(key,numberCode+"",2, TimeUnit.MINUTES);


        return ResponseResult.success();
    }

    /**
     * 校验验证码
     */
    public ResponseResult checkCode(String passengerPhone,String verificationCode){
        String key = generateKeyByPhone(passengerPhone);
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

        String token = JwtUtils.generatorToken(passengerPhone, IdentityConstant.PASSENGER_IDENTITY);

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);
        return ResponseResult.success(tokenResponse);
    }

}
