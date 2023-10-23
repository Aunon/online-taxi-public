package com.aunon.apipassenger.remote;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.NumberCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/21/23:29
 * @Description:
 */
@FeignClient("service-verificationcode")
public interface ServiceVerificationcodeClient {
    //用url获取参数
    @RequestMapping(method = RequestMethod.GET,value = "/numberCode/{size}")
    ResponseResult<NumberCodeResponse> getNumberCode(@PathVariable("size") int size);

}
