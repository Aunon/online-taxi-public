package com.aunon.apidriver.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/11/16/11:15
 * @Description:
 */
@FeignClient("service-sse-push")
public interface ServiceSsePushClient {


    @RequestMapping(method = RequestMethod.GET,value = "/push")
    public String push(@RequestParam Long userId, @RequestParam String identity, @RequestParam String content);
}
