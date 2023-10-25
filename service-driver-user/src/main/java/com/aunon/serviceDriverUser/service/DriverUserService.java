package com.aunon.serviceDriverUser.service;

import com.aunon.internalCommon.dto.DriverUser;
import com.aunon.internalCommon.dto.ResponseResult;
import com.aunon.serviceDriverUser.mapper.DriverUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
