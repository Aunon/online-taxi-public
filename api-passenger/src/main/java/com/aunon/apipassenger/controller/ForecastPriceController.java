package com.aunon.apipassenger.controller;

import com.aunon.apipassenger.service.ForecastPriceService;
import com.aunon.internalcommon.dto.ForecastPriceDTO;
import com.aunon.internalcommon.dto.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/24/10:28
 * @Description:
 */
@RestController
@Slf4j
public class ForecastPriceController {
    @Autowired
    private ForecastPriceService forecastPriceService;

    @PostMapping("/forecast-price")
    public ResponseResult forecastPrice(@RequestBody ForecastPriceDTO forecastPriceDTO){
        String depLongitude = forecastPriceDTO.getDepLongitude();
        String depLatitude = forecastPriceDTO.getDepLatitude();
        String destLongitude = forecastPriceDTO.getDestLongitude();
        String destLatitude = forecastPriceDTO.getDestLatitude();


        return forecastPriceService.forecastPrice(depLongitude,depLatitude,destLongitude,destLatitude);
    }
}
