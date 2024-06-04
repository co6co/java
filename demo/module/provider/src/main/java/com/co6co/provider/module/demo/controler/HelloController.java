package com.co6co.provider.module.demo.controler;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: CY
 * @email: 5844104706@qq.com
 * @Date: 2021/2/20 11:35
 * @Description:
 **/
@RestController
@RequestMapping("api")

public class HelloController {
    @RequestMapping("hello/{name}")
    public String  hello(@PathVariable String name){
        return String.format("Hello %s!",name);
    }
    @RequestMapping("md5/{value}")
    public String  md5(@PathVariable String value){
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    value.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
}