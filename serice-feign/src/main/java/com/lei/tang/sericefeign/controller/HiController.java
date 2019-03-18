package com.lei.tang.sericefeign.controller;

import com.lei.tang.sericefeign.feign.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanglei
 * @date 2019/3/18
 */
@RestController
public class HiController {

    /**
     * 编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
     */
    @Autowired
    SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        //通过定义的Feign客户端来消费服务
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
