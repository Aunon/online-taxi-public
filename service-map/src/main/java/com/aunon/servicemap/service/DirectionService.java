package com.aunon.servicemap.service;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.DirectionResponse;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/24/12:04
 * @Description:
 */
@Service
public class DirectionService {

    /**
     * 根据经度和纬度获取距离（米）和时长（分钟）
     * @param depLongitude
     * @param depLatitude
     * @param destLongitude
     * @param destLatitude
     * @return
     */
    public ResponseResult driving(String depLongitude,String depLatitude,String destLongitude,String destLatitude){
        DirectionResponse directionResponse = new DirectionResponse();
        directionResponse.setDistance(21);
        directionResponse.setDuration(7);
        return ResponseResult.success(directionResponse);
    }
}
