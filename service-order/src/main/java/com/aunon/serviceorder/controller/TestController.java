package com.aunon.serviceorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/11/04/22:34
 * @Description:
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test-service-order";
    }
}
