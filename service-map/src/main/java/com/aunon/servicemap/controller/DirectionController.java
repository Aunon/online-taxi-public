package com.aunon.servicemap.controller;

import com.aunon.internalcommon.dto.ForecastPriceDTO;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.servicemap.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/24/12:01
 * @Description:
 */
@RestController
@RequestMapping("/direction")
public class DirectionController {
    @Autowired
    private DirectionService directionService;

    @GetMapping("/driving")
    public ResponseResult driving(@RequestBody ForecastPriceDTO forecastPriceDTO){
        String depLongitude = forecastPriceDTO.getDepLongitude();
        String depLatitude = forecastPriceDTO.getDepLatitude();
        String destLongitude = forecastPriceDTO.getDestLongitude();
        String destLatitude = forecastPriceDTO.getDestLatitude();
        return directionService.driving(depLongitude,depLatitude,destLongitude,destLatitude);
    }
}
