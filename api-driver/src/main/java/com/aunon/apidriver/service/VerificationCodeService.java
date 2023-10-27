package com.aunon.apidriver.service;

import com.aunon.internalcommon.dto.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/27/12:51
 * @Description:
 */
@Service
public class VerificationCodeService {

    public ResponseResult checkAndSendVerificationCode(String driverPhone){
        //查询 service-driver-user,该手机号的司机是否存在

        //获取验证码

        //调用第三方发送验证码

        //存入redis
        return ResponseResult.success("");
    }
}
