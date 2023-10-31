package com.aunon.internalcommon.constant;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/24/12:48
 * @Description:
 */
public class AmapConfigConstants {
    /**
     * 路径规划url
     */
    public static final String DIRECTION_URL = "https://restapi.amap.com/v3/direction/driving";

    /**
     * 行政区域查询url
     */
    public static final String DISTRICT_URL = "https://restapi.amap.com/v3/config/district";

    /**
     * 新增服务
     */
    public static final String SERVICE_ADD_URL ="https://tsapi.amap.com/v1/track/service/add";

    /**
     * 创建终端
     */
    public static final String TERMINAL_ADD = "https://tsapi.amap.com/v1/track/terminal/add";

    /**
     * 创建轨迹
     */
    public static final String TRACK_ADD = "https://tsapi.amap.com/v1/track/trace/add";

    /**
     * 轨迹点上传
     */
    public static final String POINT_UPLOAD = "https://tsapi.amap.com/v1/track/point/upload";

    /**
     * 路径规划 json key值
     */
    public static final String STATUS = "status";
    public static final String ROUTE = "route";
    public static final String PATHS = "paths";
    public static final String DISTANCE = "distance";
    public static final String Duration = "duration";
    public static final String DISTRICTS = "districts";
    public static final String ADCODE = "adcode";
    public static final String NAME ="name";
    public static final String LEVEL = "level";
    public static final String STREET = "street";
}
