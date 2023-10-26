package com.aunon.internalcommon.requsest;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/21/16:07
 * @Description:
 */
@Data
public class VerificationCodeDTO {
    public String passengerPhone;

    public String verificationCode;
}
