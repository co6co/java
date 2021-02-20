package com.co6co.provider.module.demo.controler;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: CY
 * @email: 5844104706@qq.com
 * @Date: 2021/2/20 11:35
 * @Description:
 **/
@RestController
@RequestMapping("api")
@EnableDiscoveryClient
public class HelloController {
    @RequestMapping("hello/{name}")
    public String  hello(@PathVariable String name){
        return String.format("Hello %s!",name);
    }
}