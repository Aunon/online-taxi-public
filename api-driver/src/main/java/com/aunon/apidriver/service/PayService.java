package com.aunon.apidriver.service;

import com.aunon.apidriver.remote.ServiceSsePushClient;
import com.aunon.internalcommon.constant.IdentityConstants;
import com.aunon.internalcommon.dto.ResponseResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/11/16/11:11
 * @Description:
 */


@Service
public class PayService {

    @Autowired
    ServiceSsePushClient serviceSsePushClient;

    public ResponseResult pushPayInfo(String orderId, String price,Long passengerId){
        // 封装消息
        JSONObject message = new JSONObject();
        message.put("price",price);
        message.put("orderId",orderId);

        // 推送消息
        serviceSsePushClient.push(passengerId, IdentityConstants.PASSENGER_IDENTITY,message.toString());

        return ResponseResult.success();
    }
}
