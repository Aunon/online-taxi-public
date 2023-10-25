package com.aunon.serviceMap.controller;

import com.aunon.internalCommon.dto.DicDistrict;
import com.aunon.serviceMap.mapper.DicDistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/24/11:57
 * @Description:
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test success";
    }

    @Autowired
    private DicDistrictMapper mapper;

    @GetMapping("/test-map")
    public String testMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("address_code",110000);
        List<DicDistrict> dicDistricts = mapper.selectByMap(map);
        System.out.println(dicDistricts);
        return "test-map";
    }
}
