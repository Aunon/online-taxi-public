package com.aunon.servicemap.controller;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.servicemap.service.DicDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/25/0:04
 * @Description:
 */
@RestController
public class DicDistrictController {
    @Autowired
    private DicDistrictService dicDistrictService;

    @GetMapping("/dic-district")
    public ResponseResult initDistrict(String keywords){

        return dicDistrictService.initDicDistrict(keywords);
    }
}
