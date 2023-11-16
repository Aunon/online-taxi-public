package com.aunon.apidriver.controller;

import com.aunon.apidriver.service.UserService;
import com.aunon.internalcommon.dto.DriverUser;
import com.aunon.internalcommon.dto.DriverUserWorkStatus;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.dto.TokenResult;
import com.aunon.internalcommon.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/26/11:22
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping("/user")
    public ResponseResult updateUser(@RequestBody DriverUser driverUser){
        return userService.updateUser(driverUser);
    }

    @PostMapping("/driver-user-work-status")
    public ResponseResult changeWorkStatus(@RequestBody DriverUserWorkStatus driverUserWorkStatus){

        return userService.changeWorkStatus(driverUserWorkStatus);
    }

    /**
     * 根据司机token查询 司机和车辆绑定关系
     * @param request
     * @return
     */
    @GetMapping("/driver-car-binding-relationship")
    public ResponseResult getDriverCarBindingRelationship(HttpServletRequest request){

        String authorization = request.getHeader("Authorization");
        TokenResult tokenResult = JwtUtils.checkToken(authorization);
        String driverPhone = tokenResult.getPhone();

        return userService.getDriverCarBindingRelationship(driverPhone);

    }
}
