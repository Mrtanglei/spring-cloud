package com.lei.tang.servicezull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 路由器
 * @EnableEurekaClient注解注册Eureka服务
 * @EnableZuulProxy注解开启zuul功能
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ServiceZullApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZullApplication.class, args);
    }

}
