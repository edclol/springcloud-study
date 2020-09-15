package com.edc.springcloud.controller;
/**
 * Created by JessePinkMan on 2020/9/15 20:54
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JessePinkMan
 */
@RestController
public class ConfigController {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String port;

    @GetMapping("/config")
    public String a(){

        return appName+"  "+ eurekaServer+"  "+port;
    }

}
