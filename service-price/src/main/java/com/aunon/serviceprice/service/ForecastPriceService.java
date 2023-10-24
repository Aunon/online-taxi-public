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

import java.math.BigDecimal;
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
        double price = getPrice(distance,duration,priceRule);

        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(price);


        return ResponseResult.success(forecastPriceResponse);
    }

    /**
     * 根据距离、时长和计价规则计算价格
     * @param distance
     * @param duration
     * @param priceRule
     * @return
     */
    private double getPrice(Integer distance,Integer duration,PriceRule priceRule){
        BigDecimal price = new BigDecimal(0);
        
        //起步价
        Double startFare = priceRule.getStartFare();
        BigDecimal startFareDecimal = new BigDecimal(startFare);
        price = price.add(startFareDecimal);

        //里程费
        //总里程 m
        BigDecimal distanceDecimal = new BigDecimal(distance);
        //总里程 km
        BigDecimal distanceMileDecimal = distanceDecimal.divide(new BigDecimal(1000), 2, BigDecimal.ROUND_HALF_UP);
        //起步里程
        Integer startMile = priceRule.getStartMile();
        BigDecimal startMileDecimal = new BigDecimal(startMile);
        double distanceSubtract = distanceMileDecimal.subtract(startMileDecimal).doubleValue();
        //最终收费的里程数
        Double mile = distanceSubtract<0?0:distanceSubtract;
        BigDecimal mileDecimal = new BigDecimal(mile);
        //计价单位
        Double unitPricePerMile = priceRule.getUnitPricePerMile();
        BigDecimal unitPricePerMileDecimal = new BigDecimal(unitPricePerMile);
        //里程价格
        BigDecimal mileFare = mileDecimal.multiply(unitPricePerMileDecimal).setScale(2, BigDecimal.ROUND_HALF_UP);
        price = price.add(mileFare);

        //时长费
        BigDecimal time = new BigDecimal(duration);
        //时长的分钟数
        BigDecimal timeDecimal = time.divide(new BigDecimal(60), 2, BigDecimal.ROUND_HALF_UP);
        //计时单价
        Double unitPricePerMinute = priceRule.getUnitPricePerMinute();
        BigDecimal unitPricePerMinuteDecimal = new BigDecimal(unitPricePerMinute);
        //时长费用
        BigDecimal timeFare = timeDecimal.multiply(unitPricePerMinuteDecimal).setScale(2,BigDecimal.ROUND_HALF_UP);
        price = price.add(timeFare);

        return price.doubleValue();
    }

//    public static void main(String[] args) {
//        PriceRule priceRule = new PriceRule();
//        priceRule.setUnitPricePerMile(1.8);
//        priceRule.setUnitPricePerMinute(0.5);
//        priceRule.setStartFare(10.0);
//        priceRule.setStartMile(3);
//
//        System.out.println(getPrice(6500,1800,priceRule));
//    }
}
