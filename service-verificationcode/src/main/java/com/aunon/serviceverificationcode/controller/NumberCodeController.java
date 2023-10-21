package com.aunon.serviceverificationcode.controller;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/21/18:54
 * @Description:
 */
@RestController
public class NumberCodeController {
    @GetMapping("/numberCode/{size}")
    public ResponseResult numberCode(@PathVariable("size") int size){
        System.out.println("size:"+size);

        int random = (int)((Math.random()*9+1)*Math.pow(10,size-1));
        System.out.println(random);

        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(random);

        return ResponseResult.success(response);
    }

}
