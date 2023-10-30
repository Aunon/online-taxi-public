package com.aunon.servicemap.remote;

import com.aunon.internalcommon.constant.AmapConfigConstants;
import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.DirectionResponse;
import com.aunon.internalcommon.response.ServiceResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/30/11:16
 * @Description:
 */
@Service
public class ServiceClient {
    @Value("${amap.key}")
    private String amapKey;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseResult add(String name) {

        //组装请求调用url
        //<用户的key>
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(AmapConfigConstants.SERVICE_ADD_URL);
        urlBuilder.append("?");
        urlBuilder.append("key=" + amapKey);
        urlBuilder.append("&");
        urlBuilder.append("name=" + name);

        ResponseEntity<String> forEntity = restTemplate.postForEntity(urlBuilder.toString(), null, String.class);
        String body = forEntity.getBody();
        JSONObject result = JSONObject.fromObject(body);
        JSONObject data = result.getJSONObject("data");
        String sid = data.getString("sid");
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setSid(sid);
        return ResponseResult.success(serviceResponse);


    }
}