package com.aunon.servicedriveruser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/25/17:34
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.aunon.servicedriveruser.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceDriverUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDriverUserApplication.class);
    }
}
