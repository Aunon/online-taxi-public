package com.aunon.apiboss.service;

import com.aunon.apiboss.remote.ServiceDriverUserClient;
import com.aunon.internalcommon.dto.DriverUser;
import com.aunon.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/25/22:51
 * @Description:
 */
@Service
public class DriverUserService {
    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult addDriverUser(DriverUser driverUser){
        return serviceDriverUserClient.addDriverUser(driverUser);
    }

    public ResponseResult updateDriverUser(DriverUser driverUser){
        return serviceDriverUserClient.updateDriverUser(driverUser);
    }

}
