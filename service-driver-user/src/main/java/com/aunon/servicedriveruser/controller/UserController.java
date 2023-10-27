package com.aunon.servicedriveruser.controller;

import com.aunon.internalcommon.dto.DriverUser;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.DriverUserExistsResponse;
import com.aunon.servicedriveruser.service.DriverUserService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/25/19:44
 * @Description:
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private DriverUserService driverUserService;

    /**
     * 添加司机
     * @param driverUser
     * @return
     */
    @PostMapping("/user")
    public ResponseResult addUser(@RequestBody DriverUser driverUser){
        log.info(JSONObject.fromObject(driverUser).toString());
        return driverUserService.addDriverUser(driverUser);
    }

    /**
     * 更新司机
     * @param driverUser
     * @return
     */
    @PutMapping("/user")
    public ResponseResult updateUser(@RequestBody DriverUser driverUser){
        log.info(JSONObject.fromObject(driverUser).toString());
        return driverUserService.updateDriverUser(driverUser);
    }

    /**
     * 查询司机
     * @param
     * @return
     */
    @GetMapping("/check-driver/{driverPhone}")
    public ResponseResult getUser(@PathVariable("driverPhone")String driverPhone){
        ResponseResult<DriverUser> driverUserByPhone = driverUserService.getDriverUserByPhone(driverPhone);
        DriverUser driverUserDb = driverUserByPhone.getData();
        DriverUserExistsResponse response = new DriverUserExistsResponse();
        int ifExists =1 ;
        if(driverUserDb == null){
            ifExists=0;
            response.setDriverPhone(driverPhone);
            response.setIfExists(ifExists);
        }else {
            response.setDriverPhone(driverUserDb.getDriverPhone());
            response.setIfExists(ifExists);
        }

        return ResponseResult.success(response);
    }
}
