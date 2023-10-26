package com.aunon.servicedriveruser.service;

import com.aunon.internalcommon.dto.DriverUser;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.servicedriveruser.mapper.DriverUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/25/18:54
 * @Description:
 */
@Service
public class DriverUserService {
    @Autowired
    private DriverUserMapper driverUserMapper;

    public ResponseResult testGetDriverUser(){
        DriverUser driverUser = driverUserMapper.selectById(1);
        return ResponseResult.success(driverUser);
    }

    public ResponseResult addDriverUser(DriverUser driverUser){
        LocalDateTime now = LocalDateTime.now();
        driverUser.setGmtCreate(now);
        driverUser.setGmtModified(now);
        driverUserMapper.insert(driverUser);
        return ResponseResult.success("");
    }

    public ResponseResult updateDriverUser(DriverUser driverUser){
        LocalDateTime now = LocalDateTime.now();
        driverUser.setGmtModified(now);
        driverUserMapper.updateById(driverUser);
        return ResponseResult.success("");
    }
}
