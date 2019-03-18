package com.lei.tang.sericefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @EnableFeignClients注解开启Feign的功能
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SericeFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SericeFeignApplication.class, args);
    }

}
