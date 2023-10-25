package com.aunon.serviceDriverUser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/25/17:34
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.aunon.serviceDriverUser.mapper")
public class ServiceDriverUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDriverUserApplication.class);
    }
}
