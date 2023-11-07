package com.aunon.servicedriveruser.controller;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.servicedriveruser.mapper.DriverUserMapper;
import com.aunon.servicedriveruser.service.DriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/25/17:35
 * @Description:
 */
@RestController
public class TestController {
    @Autowired
    private DriverUserService driverUserService;

    @Autowired
    private DriverUserMapper driverUserMapper;


    @GetMapping("/test")
    public String test(){
        return "test-service-driver-user";
    }

    @GetMapping("/test-db")
    public ResponseResult testGet(){
       return driverUserService.testGetDriverUser();
    }

    @GetMapping("/test-xml")
    public int testXml(String cityCode){
        int i = driverUserMapper.selectDriverUserCountByCityCode(cityCode);
        return i;
    }
}