package com.aunon.servicemap.service;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.TrackResponse;
import com.aunon.servicemap.remote.TrackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/31/11:03
 * @Description:
 */
@Service
public class TrackService {

    @Autowired
    private TrackClient trackClient;

    public ResponseResult<TrackResponse> add(String tid){
        return trackClient.add(tid);
    }
}
