package com.aunon.internalcommon.requsest;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/31/11:53
 * @Description:
 */
@Data
public class PointRequest {
    private String tid;
    private String trid;
    private PointDTO[] points;
}
