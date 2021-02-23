package com.co6co.gateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: CY
 * @email: 5844104706@qq.com
 * @Date: 2021/2/23 14:05
 * @Description:
 **/
@RestController("hystrixpage")
public class hystrixController {
    @HystrixCommand(fallbackMethod = "helloFallback")
    @GetMapping("/hello")
    public String hello(String msg){
        throw new RuntimeException("hello throw RuntimeException");
    }
    public String helloFallback(String msg, Throwable t) {
        return "helloFallback:" + msg + "," + t.getMessage();
    }
}
