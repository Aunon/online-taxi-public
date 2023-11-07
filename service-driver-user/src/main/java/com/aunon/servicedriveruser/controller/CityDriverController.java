package com.aunon.servicedriveruser.controller;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.servicedriveruser.service.CityDriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/11/07/22:51
 * @Description:
 */
@RestController
@RequestMapping("/city-driver")
public class CityDriverController {
    @Autowired
    CityDriverUserService cityDriverUserService;

    @GetMapping("/is-available-driver")
    public ResponseResult isAvailableDriver(String cityCode){
        return cityDriverUserService.isAvailableDriver(cityCode);
    }
}
