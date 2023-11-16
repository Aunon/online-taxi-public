package com.aunon.apidriver.service;

import com.aunon.apidriver.remote.ServiceDriverUserClient;
import com.aunon.internalcommon.dto.DriverUser;
import com.aunon.internalcommon.dto.DriverUserWorkStatus;
import com.aunon.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/26/11:22
 * @Description:
 */
@Service
public class UserService {
    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult updateUser(DriverUser driverUser){
        return serviceDriverUserClient.updateUser(driverUser);
    }

    public ResponseResult changeWorkStatus(DriverUserWorkStatus driverUserWorkStatus){
        return serviceDriverUserClient.changeWorkStatus(driverUserWorkStatus);
    }
}
