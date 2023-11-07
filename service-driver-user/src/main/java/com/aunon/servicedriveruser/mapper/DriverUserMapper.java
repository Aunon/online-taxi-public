package com.aunon.servicedriveruser.mapper;

import com.aunon.internalcommon.dto.DriverUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import feign.Param;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/25/18:48
 * @Description:
 */
@Repository
public interface DriverUserMapper extends BaseMapper<DriverUser> {
    public int selectDriverUserCountByCityCode(@Param("cityCode") String cityCode);
}
