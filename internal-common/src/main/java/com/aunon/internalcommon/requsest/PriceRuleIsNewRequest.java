package com.aunon.internalcommon.requsest;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/11/07/16:01
 * @Description:
 */
@Data
public class PriceRuleIsNewRequest {

    private String fareType;

    private Integer fareVersion;
}
