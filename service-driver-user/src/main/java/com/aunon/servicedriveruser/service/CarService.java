package com.aunon.servicedriveruser.service;

import com.aunon.internalcommon.dto.Car;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.TerminalResponse;
import com.aunon.internalcommon.response.TrackResponse;
import com.aunon.servicedriveruser.mapper.CarMapper;
import com.aunon.servicedriveruser.remote.ServiceMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/26/13:21
 * @Description:
 */
@Service
public class CarService {

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private ServiceMapClient serviceMapClient;

    public ResponseResult addCar(Car car){
        LocalDateTime now = LocalDateTime.now();
        car.setGmtModified(now);
        car.setGmtCreate(now);

        // 获得此车辆 对应 的 tid
        ResponseResult<TerminalResponse> responseResult = serviceMapClient.addTerminal(car.getVehicleNo());
        String tid = responseResult.getData().getTid();
        car.setTid(tid);

        // 获得此车辆 对应 的 trid 和 trname
        ResponseResult<TrackResponse> trackResponseResponseResult = serviceMapClient.addTrack(tid);
        String trid = trackResponseResponseResult.getData().getTrid();
        String trname = trackResponseResponseResult.getData().getTrname();

        car.setTrid(trid);
        car.setTrname(trname);

        carMapper.insert(car);
        return ResponseResult.success("");
    }

}
