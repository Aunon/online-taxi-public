package com.aunon.servicemap.service;

import com.aunon.internalcommon.dto.ResponseResult;
import com.aunon.internalcommon.response.TerminalResponse;
import com.aunon.servicemap.remote.TerminalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/30/18:51
 * @Description:
 */
@Service
public class TerminalService {

    @Autowired
    private TerminalClient terminalClient;

    public ResponseResult<TerminalResponse> add(String name,String desc){
        return terminalClient.add(name,desc);
    }

    public ResponseResult<List<TerminalResponse>> aroundsearch(String center, Integer radius){
        return terminalClient.aroundsearch(center,radius);
    }
}
