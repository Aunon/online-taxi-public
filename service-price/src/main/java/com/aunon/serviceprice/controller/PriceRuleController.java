package com.aunon.serviceprice.controller;


import com.aunon.internalcommon.dto.PriceRule;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.serviceprice.service.PriceRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Aunon
 * @since 2023-11-06
 */
@RestController
@RequestMapping("/price-rule")
public class PriceRuleController {
    @Autowired
    PriceRuleService priceRuleService;

    @PostMapping("/add")
    public ResponseResult add(@RequestBody PriceRule priceRule){
        return priceRuleService.add(priceRule);
    }

    @PostMapping("/edit")
    public ResponseResult edit(@RequestBody PriceRule priceRule){
        return priceRuleService.edit(priceRule);
    }

    @GetMapping("/if-exists")
    public ResponseResult<Boolean> ifExists(@RequestBody PriceRule priceRule){
        return priceRuleService.ifExists(priceRule);
    }
}
