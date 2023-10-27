package com.aunon.internalcommon.response;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/27/20:52
 * @Description:
 */
@Data
public class DriverUserExistsResponse {
    private String driverPhone;
    private int ifExists;
}
