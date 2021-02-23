package com.co6co.consumer.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: CY
 * @email: 5844104706@qq.com
 * @Date: 2021/2/20 11:25
 * @Description:
 **/
@RestController
@RequestMapping("web")
@RefreshScope
public class HelloController {
    @Value("${service-provider-app-name}")
    private String demo_server_app_name;
    private RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    public HelloController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("hello/{name}")
    public String hello(@PathVariable String name) {

        // return restTemplate.getForEntity("http://localhost:28071/api/hello/"+name,String.class).getBody();
        // 调用SpringCloud服务提供者提供的服务
        return restTemplate.getForObject(String.format("http://%s/api/hello/%s", demo_server_app_name, name), String.class);
    }
    @RequestMapping("hello2/{name}")
    public String hello2(@PathVariable String name){
        ServiceInstance serviceInstance = loadBalancerClient.choose(demo_server_app_name);
        String url = serviceInstance.getUri() + String.format("/api/hello/%s",  name);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke : " + url + ", return : " + result;
    }
}
