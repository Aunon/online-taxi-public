package com.aunon.apiBoss.service;

import com.aunon.apiBoss.remote.ServiceDriverUserClient;
import com.aunon.internalCommon.dto.DriverUser;
import com.aunon.internalCommon.dto.ResponseResult;
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
}
