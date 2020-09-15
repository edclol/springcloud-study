package com.edc.springcloud;
/**
 * Created by JessePinkMan on 2020/9/14 21:44
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * JessePinkMan
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
public class DeptConsumerDashBoard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashBoard_9001.class,args);
    }

}
