package com.aunon.servicePassengerUser.controller;

import com.aunon.internalCommon.dto.ResponseResult;
import com.aunon.internalCommon.requsest.VerificationCodeDTO;
import com.aunon.servicePassengerUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/22/14:30
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        System.out.println("手机号："+passengerPhone);
        return userService.loginOrRegister(passengerPhone);
    }

    @GetMapping("/user/{phone}")
    public ResponseResult getUser(@PathVariable("phone") String passengerPhone){
        System.out.println("service-passenger-user: phone : "+passengerPhone);
        return userService.getUserByPhone(passengerPhone);
    }
}
