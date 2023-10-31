package com.aunon.servicemap.controller;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.requsest.PointRequest;
import com.aunon.servicemap.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/31/11:55
 * @Description:
 */
@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    private PointService pointService;

    @PostMapping("/upload")
    public ResponseResult upload(@RequestBody PointRequest pointRequest){
        return pointService.upload(pointRequest);
    }
}
