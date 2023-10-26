package com.aunon.apipassenger.controller;

import com.aunon.apipassenger.service.TokenService;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.TokenResponse;
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
