package com.aunon.apidriver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/26/11:05
 * @Description:
 */
@RestController
public class TestController {

    /**
     * 需要授权的接口
     * @return
     */
    @GetMapping("/auth")
    public String test(){
        return "auth";
    }

    /**
     * 不需要授权的接口
     * @return
     */
    @GetMapping("/noauth")
    public String testNoAuth(){
        return "no auth";
    }
}
