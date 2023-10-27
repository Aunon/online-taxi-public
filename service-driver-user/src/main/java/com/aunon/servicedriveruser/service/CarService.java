package com.aunon.servicedriveruser.service;

import com.aunon.internalcommon.dto.Car;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.servicedriveruser.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/26/13:21
 * @Description:
 */
@Service
public class CarService {
    @Autowired
    private CarMapper carMapper;

    public ResponseResult addCar(Car car){
        carMapper.insert(car);
        return ResponseResult.success("");
    }
}
