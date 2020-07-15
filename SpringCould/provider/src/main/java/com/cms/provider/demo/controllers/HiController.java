package com.cms.provider.demo.controls;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HiControl {

    @Value("${server.port}")
    int port;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name) {
        return "hi:" + name + " port:" + port;
    }
}
