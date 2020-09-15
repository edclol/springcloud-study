package com.edc.springcloud;
/**
 * Created by JessePinkMan on 2020/9/13 11:49
 */

import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * JessePinkMan
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.edc.springcloud"})//默认的是轮询，暂时不知道怎么改成自定义的规则
public class DeptConsumerFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign80.class,args);
    }

}