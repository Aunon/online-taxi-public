package com.aunon.apipassenger.service;

import com.aunon.apipassenger.remote.ServicePriceClient;
import com.aunon.internalcommon.dto.ForecastPriceDTO;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.ForecastPriceResponse;
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
    public ResponseResult forecastPrice(String depLongitude,String depLatitude,String destLongitude,String destLatitude,
                                        String cityCode,String vehicleType){

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
        forecastPriceDTO.setCityCode(cityCode);
        forecastPriceDTO.setVehicleType(vehicleType);

        ResponseResult<ForecastPriceResponse> forecast = servicePriceClient.forecast(forecastPriceDTO);


        return ResponseResult.success(forecast.getData());
    }
}
