package com.aunon.internalCommon.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/24/23:44
 * @Description:
 */
@Data
public class DicDistrict {
    private String addressCode;

    private String addressName;

    private String parentAddressCode;

    private Integer level;
}
