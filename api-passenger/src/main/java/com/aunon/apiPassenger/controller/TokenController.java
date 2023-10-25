package com.aunon.apiPassenger.controller;

import com.aunon.apiPassenger.service.TokenService;
import com.aunon.internalCommon.dto.ResponseResult;
import com.aunon.internalCommon.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/23/21:35
 * @Description:
 */
@RestController
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @PostMapping("/token-refresh")
    public ResponseResult refreshToken(@RequestBody TokenResponse tokenResponse){
        String refreshTokenSrc = tokenResponse.getRefreshToken();
        return tokenService.refreshToken(refreshTokenSrc);
    }

}
