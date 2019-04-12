package com.lei.tang.serviceribbon.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author tanglei
 * @date 2019/3/18
 */
@Slf4j
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
    public String hiService(String name){
        return restTemplate.getForEntity(UriComponentsBuilder.fromUriString("http://SERVICE-HI/hi?name={1}").build().expand(name).encode().toUri(), String.class).getBody();
//        return restTemplate.getForObject("http://SERVICE-HI/hi?name={1}" , String.class,name);
    }

    private String hiError(String name) {
        return "sorry,error!";
    }
}
