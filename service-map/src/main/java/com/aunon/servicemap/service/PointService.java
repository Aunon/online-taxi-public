package com.aunon.servicemap.service;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.requsest.PointRequest;
import com.aunon.servicemap.remote.PointClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/31/11:57
 * @Description:
 */
@Service
public class PointService {
    @Autowired
    private PointClient pointClient;

    public ResponseResult upload(PointRequest pointRequest){
        return pointClient.upload(pointRequest);
    }
}
