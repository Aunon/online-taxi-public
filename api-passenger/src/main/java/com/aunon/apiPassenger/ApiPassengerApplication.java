package com.aunon.apiPassenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/21/15:12
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ApiPassengerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiPassengerApplication.class);
    }
}
