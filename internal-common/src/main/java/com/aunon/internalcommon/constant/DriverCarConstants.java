package com.aunon.internalcommon.constant;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/27/10:21
 * @Description:
 */
public class DriverCarConstants {
    /**
     * 司机车辆关系：绑定
     */
    public static int DRIVER_CAR_BIND = 1;

    /**
     * 司机车辆关系：解绑
     */
    public static int DRIVER_CAR_UNBIND = 2;

    /**
     * 司机状态：1：有效
     */
    public static int DRIVER_STATE_VALID=1;

    /**
     * 司机状态：0：无效
     */
    public static int DRIVER_STATE_INVALID=0;

    /**
     * 司机状态：存在：1
     */
    public static int DRIVER_EXISTS = 1;

    /**
     * 司机状态：不存在：0
     */
    public static int DRIVER_NOT_EXISTS = 0;

    /**
     * 司机工作状态：收车：0
     */
    public static int DRIVER_WORK_STATUS_STOP = 0;

    /**
     * 司机工作状态：出车：1
     */
    public static int DRIVER_WORK_STATUS_START = 1;

    /**
     * 司机工作状态：暂停：2
     */
    public static int DRIVER_WORK_STATUS_SUSPEND = 2;
}
