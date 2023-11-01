package com.aunon.internalcommon.requsest;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/31/16:02
 * @Description:
 */
@Data
public class ApiDriverPointRequest {
    private Long carId;
    private PointDTO[] points;
}
