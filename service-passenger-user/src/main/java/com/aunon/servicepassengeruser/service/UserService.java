package com.aunon.servicepassengeruser.service;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.requsest.VerificationCodeDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/22/14:34
 * @Description:
 */
@Service
public class UserService {
    public ResponseResult loginOrRegister(String passengerPhone){
        System.out.println("service被调用，手机号："+passengerPhone);
        return ResponseResult.success();
    }
}
