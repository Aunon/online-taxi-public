package com.aunon.internalcommon.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/24/10:31
 * @Description:
 */
@Data
public class ForecastPriceDTO {
    private String depLongitude;
    private String depLatitude;
    private String destLongitude;
    private String destLatitude;
    private String cityCode;
    private String vehicleType;

}
