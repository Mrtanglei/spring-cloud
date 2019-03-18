package com.lei.tang.serviceribbon.controller;

import com.lei.tang.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanglei
 * @date 2019/3/18
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }
}
