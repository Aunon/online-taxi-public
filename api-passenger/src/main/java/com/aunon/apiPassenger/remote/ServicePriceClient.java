package com.aunon.apiPassenger.remote;

import com.aunon.internalCommon.dto.ForecastPriceDTO;
import com.aunon.internalCommon.dto.ResponseResult;
import com.aunon.internalCommon.response.ForecastPriceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/24/21:42
 * @Description:
 */
@FeignClient("service-price")
public interface ServicePriceClient {
    @RequestMapping(method = RequestMethod.POST,value = "/forecast-price")
    public ResponseResult<ForecastPriceResponse> forecast(@RequestBody ForecastPriceDTO forecastPriceDTO);
}
