package com.aunon.serviceprice.controller;

import com.aunon.internalcommon.dto.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/24/23:58
 * @Description:
 */
@RestController
public class DistrictController {
    @GetMapping("/dic-district")
    public ResponseResult initDistrict(){
        return null;
    }
}
