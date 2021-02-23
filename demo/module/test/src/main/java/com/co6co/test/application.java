package com.co6co.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: CY
 * @email: 5844104706@qq.com
 * @Date: 2021/2/23 10:37
 * @Description:
 **/
@Slf4j
//@SpringBootApplication
public class application {
 //   private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(application.class);
    public static void main(String[] args) {
        log.info("System.getProperty(\"user.dir\"):{}",System.getProperty("user.dir"));
        log.info("System.getProperty(\"app.home\"):{}",System.getProperty("app.home"));
        log.info("System.getProperty(\"user.home\"):{}",System.getProperty("user.home"));
       // SpringApplication.run(application.class,args);
    }
}
