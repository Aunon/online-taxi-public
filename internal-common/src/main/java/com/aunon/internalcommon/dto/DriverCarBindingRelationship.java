package com.aunon.internalcommon.dto;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Aunon
 * @since 2023-10-27
 */
@Data
public class DriverCarBindingRelationship implements Serializable {


    private Long id;

    private Long driverId;

    private Long carId;

    private Integer bindState;

    private LocalDateTime bindingTime;

    private LocalDateTime unBindingTime;

}
