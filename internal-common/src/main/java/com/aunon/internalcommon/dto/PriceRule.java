package com.aunon.internalcommon.dto;

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

    private double startFare;

    private int startMile;

    private double unitPricePerMile;

    private double unitPricePerMinute;
}
