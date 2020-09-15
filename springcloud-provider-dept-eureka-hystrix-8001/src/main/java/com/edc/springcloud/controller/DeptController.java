package com.edc.springcloud.controller;
/**
 * Created by JessePinkMan on 2020/9/12 15:33
 */

import com.edc.springcloud.pojo.Dept;
import com.edc.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * JessePinkMan
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "queryByIdHystrix")
    public Dept queryById(@PathVariable("id") long id) {
        System.out.println(id);
        Dept dept = deptService.queryById(id);
        if (dept==null){
            throw new RuntimeException("查找的id不存在");
        }
        return dept;
    }
    public Dept queryByIdHystrix(@PathVariable("id") long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("不存在的用户")
                .setDb_source("此数据库没有")
                ;
    }

    @GetMapping("/dept/list")
    public List<Dept> addDept() {
        System.out.println("listqingqiu");
        return deptService.queryAll();
    }

    @GetMapping("/dept/discovery")
    public DiscoveryClient setDiscoveryClient() {
        discoveryClient.getServices().forEach(System.out::println);

        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT-8001");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getInstanceId()+"\t"+
                    instance.getScheme()+"\t"+
                    instance.getServiceId()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"

            );

        }
        return discoveryClient;
    }

}
