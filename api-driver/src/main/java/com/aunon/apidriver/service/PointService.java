package com.aunon.apidriver.service;

import com.aunon.apidriver.remote.ServiceDriverUserClient;
import com.aunon.internalcommon.dto.Car;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.requsest.ApiDriverPointRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/31/16:04
 * @Description:
 */
@Service
public class PointService {
    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult upload(ApiDriverPointRequest apiDriverPointRequest){

        //获取carId
        Long carId = apiDriverPointRequest.getCarId();

        //通过carId 获取 tid,trid,调用 service-driver-user的接口
        ResponseResult<Car> carById = serviceDriverUserClient.getCarById(carId);
        Car car = carById.getData();
        String tid = car.getTid();
        String trid = car.getTrid();
        //调用地图去上传

        return null;
    }
}
