package com.aunon.serviceorder.controller;


import com.aunon.internalcommon.constant.HeaderParamConstants;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.requsest.OrderRequest;
import com.aunon.serviceorder.service.OrderInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Aunon
 * @since 2023-11-06
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderInfoController {
    @Autowired
    OrderInfoService orderInfoService;

    @PostMapping("/add")
    public ResponseResult add(@RequestBody OrderRequest orderRequest , HttpServletRequest httpServletRequest){
//        String deviceCode = httpServletRequest.getHeader(HeaderParamConstants.DEVICE_CODE);
//        orderRequest.setDeviceCode(deviceCode);

        log.info("service-order"+orderRequest.getAddress());
        return orderInfoService.add(orderRequest);
    }

    @GetMapping("/testMapper")
    public String testMapper(){
        return orderInfoService.testMapper();
    }


}
