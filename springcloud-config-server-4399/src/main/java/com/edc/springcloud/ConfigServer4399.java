package com.edc.springcloud;
/**
 * Created by JessePinkMan on 2020/9/14 21:44
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * JessePinkMan
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer4399 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer4399.class,args);
    }

}
