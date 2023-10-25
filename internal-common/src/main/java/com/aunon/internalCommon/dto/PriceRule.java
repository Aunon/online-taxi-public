package com.aunon.internalCommon.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/24/18:42
 * @Description:
 */
@Data
public class PriceRule {
    private String cityCode;

    private String vehicleType;

    private Double startFare;

    private Integer startMile;

    private Double unitPricePerMile;

    private Double unitPricePerMinute;
}
