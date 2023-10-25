package com.aunon.servicePassengerUser.service;

import com.aunon.internalCommon.constant.CommonStatusEnum;
import com.aunon.internalCommon.dto.PassengerUser;
import com.aunon.internalCommon.dto.ResponseResult;
import com.aunon.servicePassengerUser.mapper.PassengerUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/22/14:34
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    private PassengerUserMapper passengerUserMapper;

    /**
     * 根据手机号查询用户信息，如果没有则创建
     * @param passengerPhone
     * @return
     */
    public ResponseResult loginOrRegister(String passengerPhone){

        System.out.println("service被调用，手机号："+passengerPhone);

        Map<String,Object> map = new HashMap<>();
        map.put("passenger_phone",passengerPhone);
        List<PassengerUser> passengerUsers = passengerUserMapper.selectByMap(map);

        if(passengerUsers.size()==0){
            PassengerUser passengerUser = new PassengerUser();
            passengerUser.setPassengerName("张三");
            passengerUser.setPassengerGender((byte) 0);
            passengerUser.setPassengerPhone(passengerPhone);
            passengerUser.setState((byte) 0);

            LocalDateTime now = LocalDateTime.now();
            passengerUser.setGmtCreate(now);
            passengerUser.setGmtModified(now);

            passengerUserMapper.insert(passengerUser);
        }


        return ResponseResult.success();
    }

    /**
     * 根据手机号查询用户信息
     * @param passengerPhone
     * @return
     */
    public ResponseResult getUserByPhone(String passengerPhone){
        Map<String,Object> map = new HashMap<>();
        map.put("passenger_phone",passengerPhone);
        List<PassengerUser> passengerUsers = passengerUserMapper.selectByMap(map);
        if(passengerUsers.size()==0){
            return ResponseResult.fail(CommonStatusEnum.USER_NOT_EXISTS.getCode(),CommonStatusEnum.USER_NOT_EXISTS.getValue());
        }else{
            PassengerUser passengerUser = passengerUsers.get(0);
            return ResponseResult.success(passengerUser);
        }

    }
}
