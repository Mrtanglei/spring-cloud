package com.lei.tang.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * spring cloud中discovery service有许多种实现（eureka、consul、zookeeper等等），@EnableDiscoveryClient基于spring-cloud-commons,
 *
 * @EnableEurekaClient基于spring-cloud-netflix。 其实用更简单的话来说，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient
 * ，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
 * @EnableHystrix 注解开启Hystrix断路器
 */
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    /**
     * @return
     * @LoadBalanced注解表明RestTemplate开启负载均衡的功能
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
