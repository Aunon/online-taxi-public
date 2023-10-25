package com.aunon.internalCommon.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/25/18:43
 * @Description:
 */
@Data
public class DriverUser {


    private Long id;
    private String address;
    private String driverName;
    private String driverPhone;
    private Integer driverGender;
    private Date driverBirthday;
    private String driverNation;
    private String driverContactAddress;
    private String licenseId;

    private Date getDriverLicenseDate;
    private Date driverLicenseOn;
    private Date driverLicenseOff;
    private Integer taxiDriver;
    private String certificateNo;
    private String networkCarIssueOrganization;
    private Date networkCarIssueDate;
    private Date getNetworkCarProofDate;
    private Date networkCarProofOn;
    private Date networkCarProofOff;
    private Date registerDate;
    private Integer commercialType;
    private String contractCompany;
    private Date contractOn;
    private Date contractOff;
    private Integer state;


    private Date gmtCreate;
    private Date gmtModified;
}
