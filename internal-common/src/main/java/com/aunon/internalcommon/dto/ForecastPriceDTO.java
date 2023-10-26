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
    public String depLongitude;
    public String depLatitude;
    public String destLongitude;
    public String destLatitude;
}
