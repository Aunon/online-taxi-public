package com.aunon.servicedriveruser.service;

import com.aunon.internalcommon.constant.CommonStatusEnum;
import com.aunon.internalcommon.constant.DriverCarConstants;
import com.aunon.internalcommon.dto.DriverCarBindingRelationship;
import com.aunon.internalcommon.dto.DriverUser;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.servicedriveruser.mapper.DriverCarBindingRelationshipMapper;
import com.aunon.servicedriveruser.mapper.DriverUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/27/10:20
 * @Description:
 */
@Service
public class DriverCarBindingRelationshipService {
    @Autowired
    private DriverCarBindingRelationshipMapper driverCarBindingRelationshipMapper;

    @Autowired
    DriverUserMapper driverUserMapper;

    public ResponseResult bind(DriverCarBindingRelationship driverCarBindingRelationship){
        //判断，如果参数中的司机和车辆已经做过绑定，则不允许再次绑定
        QueryWrapper<DriverCarBindingRelationship> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("driver_id",driverCarBindingRelationship.getDriverId());
        queryWrapper.eq("car_id",driverCarBindingRelationship.getCarId());
        queryWrapper.eq("bind_state",DriverCarConstants.DRIVER_CAR_BIND);

        Integer integer  = driverCarBindingRelationshipMapper.selectCount(queryWrapper);
        if((integer.intValue())>0){
            return ResponseResult.fail(CommonStatusEnum.DRIVER_CAR_BIND_EXISTS.getCode(),CommonStatusEnum.DRIVER_CAR_BIND_EXISTS.getValue());
        }

        //司机已被绑定
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("driver_id",driverCarBindingRelationship.getCarId());
        queryWrapper.eq("bind_state",DriverCarConstants.DRIVER_CAR_BIND);
        integer = driverCarBindingRelationshipMapper.selectCount(queryWrapper);
        if (integer.intValue() > 0) {
            return ResponseResult.fail(CommonStatusEnum.DRIVER_BIND_EXISTS.getCode(),CommonStatusEnum.DRIVER_BIND_EXISTS.getValue());

        }

        //车辆已被绑定
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("car_id",driverCarBindingRelationship.getCarId());
        queryWrapper.eq("bind_state",DriverCarConstants.DRIVER_CAR_BIND);
        integer = driverCarBindingRelationshipMapper.selectCount(queryWrapper);
        if (integer.intValue() > 0) {
            return ResponseResult.fail(CommonStatusEnum.CAR_BIND_EXISTS.getCode(),CommonStatusEnum.CAR_BIND_EXISTS.getValue());

        }

        LocalDateTime now =LocalDateTime.now();
        driverCarBindingRelationship.setBindingTime(now);
        driverCarBindingRelationship.setBindState(DriverCarConstants.DRIVER_CAR_BIND);

        driverCarBindingRelationshipMapper.insert(driverCarBindingRelationship);

        return ResponseResult.success("");
    }

    public ResponseResult unbind(DriverCarBindingRelationship driverCarBindingRelationship){
        LocalDateTime now = LocalDateTime.now();
        Map<String,Object> map = new HashMap<>();
        map.put("driver_id",driverCarBindingRelationship.getDriverId());
        map.put("car_id",driverCarBindingRelationship.getCarId());
        map.put("bind_state",DriverCarConstants.DRIVER_CAR_BIND);
        List<DriverCarBindingRelationship> driverCarBindingRelationships = driverCarBindingRelationshipMapper.selectByMap(map);
        if(driverCarBindingRelationships.isEmpty()){
            return ResponseResult.fail(CommonStatusEnum.DRIVER_CAR_BIND_NOT_EXISTS.getCode(),CommonStatusEnum.DRIVER_CAR_BIND_NOT_EXISTS.getValue());

        }
        DriverCarBindingRelationship relationship = driverCarBindingRelationships.get(0);
        relationship.setUnBindingTime(now);
        relationship.setBindState(DriverCarConstants.DRIVER_CAR_UNBIND);

        driverCarBindingRelationshipMapper.updateById(relationship);

        return ResponseResult.success("");

    }

    public ResponseResult<DriverCarBindingRelationship> getDriverCarRelationShipByDriverPhone(@RequestParam String driverPhone){
        QueryWrapper<DriverUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("driver_phone",driverPhone);

        DriverUser driverUser = driverUserMapper.selectOne(queryWrapper);
        Long driverId = driverUser.getId();

        QueryWrapper<DriverCarBindingRelationship> driverCarBindingRelationshipQueryWrapper = new QueryWrapper<>();
        driverCarBindingRelationshipQueryWrapper.eq("driver_id",driverId);
        driverCarBindingRelationshipQueryWrapper.eq("bind_state",DriverCarConstants.DRIVER_CAR_BIND);

        DriverCarBindingRelationship driverCarBindingRelationship = driverCarBindingRelationshipMapper.selectOne(driverCarBindingRelationshipQueryWrapper);
        return ResponseResult.success(driverCarBindingRelationship);

    }
}
