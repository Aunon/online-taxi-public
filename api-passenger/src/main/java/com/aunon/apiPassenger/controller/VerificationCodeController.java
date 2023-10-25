package com.aunon.apiPassenger.controller;

import com.aunon.apiPassenger.service.VerificationCodeService;
import com.aunon.internalCommon.dto.ResponseResult;
import com.aunon.internalCommon.requsest.VerificationCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/21/16:03
 * @Description:
 */
@RestController
public class VerificationCodeController {
    @Autowired
    private VerificationCodeService verificationCodeService;

    @GetMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String passengerPhone = verificationCodeDTO.getPassengerPhone();

        return  verificationCodeService.generatorCode(passengerPhone);
    }

    @PostMapping("/verification-code-check")
    public ResponseResult checkVerificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        String verificationCode = verificationCodeDTO.getVerificationCode();

        System.out.println("手机号："+passengerPhone+" 验证码:"+verificationCode);

        return verificationCodeService.checkCode(passengerPhone,verificationCode);


    }
}
