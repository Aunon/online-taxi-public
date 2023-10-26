package com.aunon.internalcommon.response;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/22/11:17
 * @Description:
 */

@Data
public class TokenResponse {
    private String accessToken;
    private String refreshToken;
}
