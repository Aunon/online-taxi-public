package com.aunon.servicedriveruser.service;

import com.aunon.internalcommon.dto.DriverUserWorkStatus;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.servicedriveruser.mapper.DriverUserWorkStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/28/23:20
 * @Description:
 */
@Service
public class DriverUserWorkStatusService {
    @Autowired
    DriverUserWorkStatusMapper driverUserWorkStatusMapper;

    public ResponseResult changeWorkStatus(Long driverId,Integer workStatus){
        Map<String,Object> map = new HashMap<>();
        map.put("driver_id",driverId);
        List<DriverUserWorkStatus> driverUserWorkStatuses = driverUserWorkStatusMapper.selectByMap(map);
        DriverUserWorkStatus driverUserWorkStatus = driverUserWorkStatuses.get(0);
        driverUserWorkStatus.setWorkStatus(workStatus);
        driverUserWorkStatusMapper.updateById(driverUserWorkStatus);
        return ResponseResult.success();
    }
}
