package com.aunon.apipassenger.controller;

import com.aunon.apipassenger.remote.ServiceOrderClient;
import com.aunon.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 需要有token
     * @return
     */
    @GetMapping("/authTest")
    public ResponseResult authTest(){
        return ResponseResult.success("auth test");
    }

    /**
     * 没有token也能正常返回
     * @return
     */
    @GetMapping("/noauthTest")
    public ResponseResult noauthTest(){
        return ResponseResult.success("noauth test");
    }

    @Autowired
    ServiceOrderClient serviceOrderClient;

    /**
     * 测试派单逻辑
     * @param orderId
     * @return
     */
    @GetMapping("/test-real-time-order/{orderId}")
    public String dispatchRealTimeOrder(@PathVariable("orderId") long orderId){
        System.out.println("并发测试：api-passenger："+orderId);
        serviceOrderClient.dispatchRealTimeOrder(orderId);
        return "test-real-time-order   success";
    }
}
