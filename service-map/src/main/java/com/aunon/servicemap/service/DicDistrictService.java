package com.aunon.servicemap.service;

import com.aunon.internalcommon.constant.AmapConfigConstants;
import com.aunon.internalcommon.dto.ResponseResult;
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
    @Value("${amap.key}")
    private String amapKey;

    public ResponseResult initDicDistrict(String keywords){
        //<用户的key>

        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.DISTRICT_URL);
        url.append("?");
        url.append("keywords="+keywords);
        url.append("&");
        url.append("subdistrict=3");
        url.append("&");
        url.append("key="+amapKey);

        return ResponseResult.success();
    }
}
