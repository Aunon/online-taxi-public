package com.aunon.serviceprice.service;

import com.aunon.internalcommon.constant.CommonStatusEnum;
import com.aunon.internalcommon.dto.ForecastPriceDTO;
import com.aunon.internalcommon.dto.PriceRule;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.DirectionResponse;
import com.aunon.internalcommon.response.ForecastPriceResponse;
import com.aunon.serviceprice.mapper.PriceRuleMapper;
import com.aunon.serviceprice.remote.ServiceMapClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private PriceRuleMapper priceRuleMapper;

    @Autowired
    private ServiceMapClient serviceMapClient;

    public ResponseResult forecastPrice(String depLongitude,String depLatitude,String destLongitude,String destLatitude){
        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(12.32);

        log.info("DepLongitude :"+depLongitude);
        log.info("DepLatitude :"+depLatitude);
        log.info("DestLongitude :"+destLongitude);
        log.info("DestLatitude :"+destLatitude);

        //调用地图服务，查询距离和时长
        ForecastPriceDTO forecastPriceDTO = new ForecastPriceDTO();
        forecastPriceDTO.setDepLongitude(depLongitude);
        forecastPriceDTO.setDepLatitude(depLatitude);
        forecastPriceDTO.setDestLongitude(destLongitude);
        forecastPriceDTO.setDestLatitude(destLatitude);
        ResponseResult<DirectionResponse> direction = serviceMapClient.direction(forecastPriceDTO);

        Integer distance = direction.getData().getDistance();
        Integer duration = direction.getData().getDuration();

        log.info("距离："+distance+"，时长："+duration);


        //读取计价规则
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("city_code","110000");
        queryMap.put("vehicle_type","1");
        List<PriceRule> priceRules = priceRuleMapper.selectByMap(queryMap);
        if(priceRules.size()==0){
            return ResponseResult.fail(CommonStatusEnum.PRICE_RULE_EMPTY.getCode(),CommonStatusEnum.PRICE_RULE_EMPTY.getValue());
        }
        PriceRule priceRule = priceRules.get(0);

        //根据距离、时长和计价规则计算价格

        return ResponseResult.success(forecastPriceResponse);
    }
}
