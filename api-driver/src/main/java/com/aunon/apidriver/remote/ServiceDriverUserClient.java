package com.aunon.apidriver.remote;

import com.aunon.internalcommon.dto.DriverUser;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.DriverUserExistsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/26/11:25
 * @Description:
 */
@FeignClient("service-driver-user")
public interface ServiceDriverUserClient {

    @RequestMapping(method = RequestMethod.PUT,value = "/user")
    public ResponseResult updateUser(@RequestBody DriverUser driverUser);

    @RequestMapping(method = RequestMethod.GET,value = "/check-driver/{driverPhone}")
    public ResponseResult<DriverUserExistsResponse> checkDriver(@PathVariable("driverPhone") String driverPhone);
}
