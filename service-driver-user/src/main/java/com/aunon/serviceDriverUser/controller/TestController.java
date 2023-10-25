package com.aunon.serviceDriverUser.controller;

import com.aunon.internalCommon.dto.ResponseResult;
import com.aunon.serviceDriverUser.service.DriverUserService;
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


    @GetMapping("/test")
    public String test(){
        return "test-service-driver-user";
    }

    @GetMapping("/test-db")
    public ResponseResult testGet(){
       return driverUserService.testGetDriverUser();
    }
}