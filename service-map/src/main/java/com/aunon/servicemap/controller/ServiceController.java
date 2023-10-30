package com.aunon.servicemap.controller;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.servicemap.service.ServiceFromMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/30/11:10
 * @Description:服务管理控制器
 */
@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceFromMapService serviceFromMapService;
    /**
     * 创建服务
     * @param name
     * @return
     */
    @PostMapping("/add")
    public ResponseResult add(String name){
        return serviceFromMapService.add(name);
    }
}
