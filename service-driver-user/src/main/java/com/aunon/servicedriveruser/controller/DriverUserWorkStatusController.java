package com.aunon.servicedriveruser.controller;


import com.aunon.internalcommon.dto.DriverUserWorkStatus;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.servicedriveruser.service.DriverUserWorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Aunon
 * @since 2023-10-28
 */
@RestController
public class DriverUserWorkStatusController {
    @Autowired
    DriverUserWorkStatusService driverUserWorkStatusService;

    @GetMapping("/driver-user-work-status")
    public ResponseResult changeWorkStatus(@RequestBody DriverUserWorkStatus driverUserWorkStatus){
        return driverUserWorkStatusService.changeWorkStatus(driverUserWorkStatus.getDriverId(),driverUserWorkStatus.getWorkStatus());
    }
}
