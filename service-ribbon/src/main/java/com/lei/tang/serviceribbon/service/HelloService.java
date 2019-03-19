package com.lei.tang.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author tanglei
 * @date 2019/3/18
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 当hiService方法中发送错误时，则会执行fallbackMethod回调
     *
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    private String hiError(String name) {
        return "sorry,error!";
    }
}
