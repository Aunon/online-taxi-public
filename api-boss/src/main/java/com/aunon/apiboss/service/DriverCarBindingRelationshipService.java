package com.aunon.apiboss.service;

import com.aunon.apiboss.remote.ServiceDriverUserClient;
import com.aunon.internalcommon.dto.DriverCarBindingRelationship;
import com.aunon.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/27/11:24
 * @Description:
 */
@Service
public class DriverCarBindingRelationshipService {
    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult bind(DriverCarBindingRelationship driverCarBindingRelationship){
        return serviceDriverUserClient.bind(driverCarBindingRelationship);
    }

    public ResponseResult unbind(DriverCarBindingRelationship driverCarBindingRelationship){
        return serviceDriverUserClient.unbind(driverCarBindingRelationship);
    }
}
