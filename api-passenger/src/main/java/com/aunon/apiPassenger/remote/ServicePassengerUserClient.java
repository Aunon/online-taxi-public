package com.aunon.apiPassenger.remote;

import com.aunon.internalCommon.dto.PassengerUser;
import com.aunon.internalCommon.dto.ResponseResult;
import com.aunon.internalCommon.requsest.VerificationCodeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/22/18:33
 * @Description:
 */
@FeignClient("service-passenger-user")
public interface ServicePassengerUserClient {
    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO verificationCodeDTO);

    @RequestMapping(method = RequestMethod.GET,value = "/user/{phone}")
    public ResponseResult<PassengerUser> getUserByPhone(@PathVariable("phone") String phone);
}
