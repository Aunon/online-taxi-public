package com.aunon.apiPassenger.controller;

import com.aunon.apiPassenger.service.UserService;
import com.aunon.internalCommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/23/23:19
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseResult getUser(HttpServletRequest request){
        String accessToken = request.getHeader("Authorization");
        return userService.getUserByAccessToken(accessToken);
    }
}
