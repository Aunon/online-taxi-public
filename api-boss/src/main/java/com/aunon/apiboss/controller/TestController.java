package com.aunon.apiboss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/25/22:21
 * @Description:
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test-api-boss";
    }
}
