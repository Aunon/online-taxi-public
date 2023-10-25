package com.aunon.servicemap.service;

import com.aunon.internalcommon.constant.AmapConfigConstants;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.servicemap.remote.MapDicDistrictClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/25/0:05
 * @Description:
 */
@Service
public class DicDistrictService {
    @Autowired
    private MapDicDistrictClient mapDicDistrictClient;

    public ResponseResult initDicDistrict(String keywords){
        //请求地图
        String dicDistrict = mapDicDistrictClient.dicDistrict(keywords);
        System.out.println(dicDistrict);
        //解析结果

        //插入数据库

        return ResponseResult.success();
    }
}
