package com.aunon.serviceverificationcode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/21/17:20
 * @Description:
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "test service-verification";
    }
}
