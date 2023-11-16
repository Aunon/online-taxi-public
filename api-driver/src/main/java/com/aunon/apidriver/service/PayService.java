package com.aunon.apidriver.service;

import com.aunon.internalcommon.dto.ResponseResult;
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

    public ResponseResult pushPayInfo(String orderId, String price,Long passengerId){
        // 封装消息

        // 推送消息

        return ResponseResult.success();
    }
}
