package com.lei.tang.sericefeign.feign;

import com.lei.tang.sericefeign.hystrix.SchedualServiceHiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tanglei
 * @date 2019/3/18
 * <p>
 * Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。使用Feign，只需要创建一个借口并注解。它具有可插拔的注解特性，可使用Feign注解和JAX-RS注解。Feign
 * 支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
 * <p>
 * Feign采用的是基于借口的注解；整合了Ribbon，具有负载均衡的能力；整合了Hystrix，具有熔断的能力
 * <p>
 * 通过@FeignClient("服务名")来指定调用哪个服务
 */
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystrix.class)
public interface SchedualServiceHi {

    @GetMapping(value = "/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
