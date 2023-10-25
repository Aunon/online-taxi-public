package com.aunon.apiPassenger.service;

import com.aunon.apiPassenger.remote.ServicePriceClient;
import com.aunon.internalCommon.dto.ForecastPriceDTO;
import com.aunon.internalCommon.dto.ResponseResult;
import com.aunon.internalCommon.response.ForecastPriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/24/10:38
 * @Description:
 */
@Service
@Slf4j
public class ForecastPriceService {

    @Autowired
    private ServicePriceClient servicePriceClient;

    /**
     * 根据出发地和目的地经纬度预估价格
     * @param depLongitude
     * @param depLatitude
     * @param destLongitude
     * @param destLatitude
     * @return
     */
    public ResponseResult forecastPrice(String depLongitude,String depLatitude,String destLongitude,String destLatitude){

        log.info("DepLongitude :"+depLongitude);
        log.info("DepLatitude :"+depLatitude);
        log.info("DestLongitude :"+destLongitude);
        log.info("DestLatitude :"+destLatitude);

        //调用计价服务，计算价格
        ForecastPriceDTO forecastPriceDTO = new ForecastPriceDTO();
        forecastPriceDTO.setDepLongitude(depLongitude);
        forecastPriceDTO.setDepLatitude(depLatitude);
        forecastPriceDTO.setDestLongitude(destLongitude);
        forecastPriceDTO.setDestLatitude(destLatitude);

        ResponseResult<ForecastPriceResponse> forecast = servicePriceClient.forecast(forecastPriceDTO);
        double price = forecast.getData().getPrice();

        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(price);

        return ResponseResult.success(forecastPriceResponse);
    }
}
