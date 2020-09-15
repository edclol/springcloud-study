package com.edc.springcloud;
/**
 * Created by JessePinkMan on 2020/9/13 11:49
 */

import com.edc.myrule.EdcRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * JessePinkMan
 */

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = RoundRobinRule.class)
public class DeptConsumerRibbon80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerRibbon80.class,args);
    }

}