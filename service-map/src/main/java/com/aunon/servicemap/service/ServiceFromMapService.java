package com.aunon.servicemap.service;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.servicemap.remote.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/30/11:12
 * @Description:
 */
@Service
public class ServiceFromMapService {
    @Autowired
    private ServiceClient serviceClient;

    /**
     * 创建服务
     * @param name
     * @return
     */
    public ResponseResult add(String name){
        return serviceClient.add(name);
    }
}
