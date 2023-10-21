package com.aunon.apipassenger.service;

import com.aunon.apipassenger.remote.ServiceVerificationcodeClient;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String generatorCode(String passengerPhone){
        System.out.println("调用验证码服务,获取验证码");

        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();
        System.out.println("remote number code:"+numberCode);

        System.out.println("存入redis");

        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("message","success");

        return result.toString();
    }
}
