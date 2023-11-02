package com.aunon.apipassenger.controller;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.requsest.OrderRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/11/02/11:20
 * @Description:
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 创建订单/下单
     * @return
     */
    @PostMapping("/add")
    public ResponseResult add(@RequestBody OrderRequest orderRequest){
        System.out.println(orderRequest);
        return null;
    }
}
