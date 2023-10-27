package com.aunon.apidriver.service;

import com.aunon.apidriver.remote.ServiceDriverUserClient;
import com.aunon.internalcommon.constant.CommonStatusEnum;
import com.aunon.internalcommon.constant.DriverCarConstants;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.DriverUserExistsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/27/12:51
 * @Description:
 */
@Service
@Slf4j
public class VerificationCodeService {
    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult checkAndSendVerificationCode(String driverPhone){
        //查询 service-driver-user,该手机号的司机是否存在
        ResponseResult<DriverUserExistsResponse> driverUserExistsResponseResponseResult = serviceDriverUserClient.checkDriver(driverPhone);
        DriverUserExistsResponse data = driverUserExistsResponseResponseResult.getData();
        int ifExists = data.getIfExists();
        if(ifExists == DriverCarConstants.DRIVER_NOT_EXISTS){
            return ResponseResult.fail(CommonStatusEnum.DRIVER_NOT_EXISTS.getCode(),CommonStatusEnum.DRIVER_NOT_EXISTS.getValue());
        }
        log.info(driverPhone + "的司机存在");

        //获取验证码

        //调用第三方发送验证码

        //存入redis
        return ResponseResult.success("");
    }
}
