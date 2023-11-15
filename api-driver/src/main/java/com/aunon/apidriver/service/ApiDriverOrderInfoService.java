package com.aunon.apidriver.service;


import com.aunon.apidriver.remote.ServiceOrderClient;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.requsest.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/11/15/22:01
 * @Description:
 */
@Service
public class ApiDriverOrderInfoService {

    @Autowired
    ServiceOrderClient serviceOrderClient;

    public ResponseResult toPickUpPassenger(@RequestBody OrderRequest orderRequest){
        return serviceOrderClient.toPickUpPassenger(orderRequest);
    }

}
