package com.aunon.serviceprice.service;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.ForecastPriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/24/11:28
 * @Description:
 */
@Service
@Slf4j
public class ForecastPriceService {

    public ResponseResult forecastPrice(String depLongitude,String depLatitude,String destLongitude,String destLatitude){
        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(12.32);

        log.info("DepLongitude :"+depLongitude);
        log.info("DepLatitude :"+depLatitude);
        log.info("DestLongitude :"+destLongitude);
        log.info("DestLatitude :"+destLatitude);

        //预估地图服务，查询距离和时长

        //读取计价规则

        //根据距离、时长和计价规则计算价格

        return ResponseResult.success(forecastPriceResponse);
    }
}
