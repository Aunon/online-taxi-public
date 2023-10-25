package com.aunon.servicePrice.remote;

import com.aunon.internalCommon.dto.ForecastPriceDTO;
import com.aunon.internalCommon.dto.ResponseResult;
import com.aunon.internalCommon.response.DirectionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/24/17:08
 * @Description:
 */
@FeignClient("service-map")
public interface ServiceMapClient {
    @RequestMapping(method = RequestMethod.GET,value = "/direction/driving")
    public ResponseResult<DirectionResponse> direction(@RequestBody ForecastPriceDTO forecastPriceDTO);
}
