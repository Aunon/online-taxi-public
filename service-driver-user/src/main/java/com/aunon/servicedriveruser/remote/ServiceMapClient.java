package com.aunon.servicedriveruser.remote;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.TerminalResponse;
import com.aunon.internalcommon.response.TrackResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/30/19:34
 * @Description:
 */
@FeignClient("service-map")
public interface ServiceMapClient {

    @RequestMapping(method = RequestMethod.POST, value = "/terminal/add")
    public ResponseResult<TerminalResponse> addTerminal(@RequestParam String name);

    @RequestMapping(method = RequestMethod.POST,value = "/track/add")
    public ResponseResult<TrackResponse> addTrack(@RequestParam String tid);
}