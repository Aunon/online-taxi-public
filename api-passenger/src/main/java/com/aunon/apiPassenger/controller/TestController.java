package com.aunon.apiPassenger.controller;

import com.aunon.internalCommon.dto.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/21/15:14
 * @Description:
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "test api passenger";
    }

    @GetMapping("/authTest")
    public ResponseResult authTest(){
        return ResponseResult.success("auth test");
    }

    @GetMapping("/noAuthTest")
    public ResponseResult noAuthTest(){
        return ResponseResult.success("noAuth test");
    }
}
