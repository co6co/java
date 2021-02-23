package com.co6co.consumer.demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: CY
 * @email: 5844104706@qq.com
 * @Date: 2021/2/20 11:35
 * @Description:
 **/
@Configuration //等价于一个Spring  applicationContext.xml配置文件
public class BeanConfig {
    /*
    * === <bean id="restTemplate" class="org.springframework.web.client.RestTemplate" ></bean>
    * */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
