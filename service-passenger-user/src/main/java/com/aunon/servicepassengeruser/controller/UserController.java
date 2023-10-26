package com.aunon.servicepassengeruser.controller;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.requsest.VerificationCodeDTO;
import com.aunon.servicepassengeruser.service.UserService;
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
