package com.aunon.apiboss.service;

import com.aunon.apiboss.remote.ServiceDriverUserClient;
import com.aunon.internalcommon.dto.Car;
import com.aunon.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/27/10:59
 * @Description:
 */
@Service
public class CarService {
    @Autowired
    private ServiceDriverUserClient driverUserClient;

    public ResponseResult addCar(Car car){
        return driverUserClient.addCar(car);
    }
}
