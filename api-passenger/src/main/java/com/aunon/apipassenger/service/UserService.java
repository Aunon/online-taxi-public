package com.aunon.apipassenger.service;

import com.aunon.apipassenger.remote.ServicePassengerUserClient;
import com.aunon.internalcommon.dto.PassengerUser;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.dto.TokenResult;
import com.aunon.internalcommon.requsest.VerificationCodeDTO;
import com.aunon.internalcommon.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/23/23:22
 * @Description:
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private ServicePassengerUserClient servicePassengerUserClient;

    public ResponseResult getUserByAccessToken(String accessToken){
        log.info("accessToken : "+accessToken);
        //解析accessToken拿到Phone
        TokenResult tokenResult = JwtUtils.checkToken(accessToken);
        String phone = tokenResult.getPhone();
        log.info("phone : "+phone);

        //根据手机号查询用户信息
        ResponseResult<PassengerUser> userByPhone = servicePassengerUserClient.getUserByPhone(phone);

        return ResponseResult.success(userByPhone.getData());
    }
}
