package com.aunon.apidriver.controller;

import com.aunon.apidriver.service.VerificationCodeService;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.requsest.VerificationCodeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/27/12:21
 * @Description:
 */
@RestController
@Slf4j
public class VerificationCodeController {
    @Autowired
    private VerificationCodeService verificationCodeService;

    @GetMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String driverPhone = verificationCodeDTO.getDriverPhone();
        log.info("driverPhone:"+ driverPhone);
        return verificationCodeService.checkAndSendVerificationCode(driverPhone);
    }

    @PostMapping("/verification-code-check")
    public ResponseResult checkVerificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String driverPhone = verificationCodeDTO.getDriverPhone();
        String verificationCode = verificationCodeDTO.getVerificationCode();

        System.out.println("手机号："+driverPhone+" 验证码:"+verificationCode);

        return verificationCodeService.checkCode(driverPhone,verificationCode);

    }
}
