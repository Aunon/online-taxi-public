package com.aunon.serviceorder.service;

import com.aunon.internalcommon.dto.OrderInfo;
import com.aunon.serviceorder.mapper.OrderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/11/06/18:55
 * @Description:
 */
@Service
public class OrderInfoService {
    @Autowired
    OrderInfoMapper orderInfoMapper;

    public String testMapper(){
        OrderInfo o = new OrderInfo();
        o.setAddress("110000");
        orderInfoMapper.insert(o);
        return "";
    }
}
