package com.aunon.servicessepush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/11/14/19:56
 * @Description:
 */


@SpringBootApplication
@EnableDiscoveryClient
public class ServiceSsePushApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSsePushApplication.class,args);
    }
}