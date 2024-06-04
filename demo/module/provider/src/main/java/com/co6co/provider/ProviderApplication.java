package com.co6co.provider;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Properties;

/**
 * @Author: CY
 * @email: 5844104706@qq.com
 * @Date: 2021/2/20 11:34
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication {
    public static void main(String[] args) {
       /*try{
           String serverAddr = "localhost";
           String dataId = "demo-provider.yml";
           String group = "DEFAULT_GROUP";
           Properties properties = new Properties();
           properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
           ConfigService configService = NacosFactory.createConfigService(properties);
           String content = configService.getConfig(dataId, group, 5000);
           System.out.println(content);
       }
       catch (Exception e){}*/


        SpringApplication.run(ProviderApplication.class,args);
    }
}
