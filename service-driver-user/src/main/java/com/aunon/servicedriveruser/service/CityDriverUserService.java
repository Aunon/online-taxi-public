package com.aunon.servicedriveruser.service;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.servicedriveruser.mapper.DriverUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/11/07/22:47
 * @Description:
 */
@Service
public class CityDriverUserService {
    @Autowired
    DriverUserMapper driverUserMapper;

    public ResponseResult<Boolean> isAvailableDriver(String cityCode){
        int i = driverUserMapper.selectDriverUserCountByCityCode(cityCode);
        if (i > 0){
            return ResponseResult.success(true);
        }else{
            return ResponseResult.success(false);
        }
    }
}
