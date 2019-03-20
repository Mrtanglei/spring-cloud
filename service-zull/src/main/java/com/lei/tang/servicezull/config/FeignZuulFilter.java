package com.lei.tang.servicezull.config;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author tanglei
 * @date 2019/3/19
 *
 * 只针对 /api/feign/**请求过滤
 */
@Slf4j
@Component
public class FeignZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        log.info("in FeignZuulFilter filterType");
        return "pre";
    }

    @Override
    public int filterOrder() {
        log.info("in FeignZuulFilter filterOrder");
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        log.info("in FeignZuulFilter shouldFilter");
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        return StringUtils.hasText(request.getServletPath()) && request.getServletPath().startsWith("/api/feign/");
    }

    @Override
    public Object run() throws ZuulException {
        log.info("in FeignZuulFilter run");
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String name = request.getParameter("name");
        if(!StringUtils.hasText(name) || !"bb".equals(name)){
            try {
                RequestContext.getCurrentContext().getResponse().getWriter().write("name is error");
                RequestContext.getCurrentContext().getResponse().getWriter().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
