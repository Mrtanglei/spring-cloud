package com.lei.tang.sericefeign.hystrix;

import com.lei.tang.sericefeign.feign.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author tanglei
 * @date 2019/3/19
 */
@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "来自遥远深处的错误";
    }
}
