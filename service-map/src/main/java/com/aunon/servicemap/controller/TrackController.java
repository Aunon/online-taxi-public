package com.aunon.servicemap.controller;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.TrackResponse;
import com.aunon.servicemap.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/31/11:02
 * @Description:
 */
@RestController
@RequestMapping("/track")
public class TrackController {
    @Autowired
    private TrackService trackService;

    @PostMapping("/add")
    public ResponseResult<TrackResponse> add(String tid){

        return trackService.add(tid);
    }
}
