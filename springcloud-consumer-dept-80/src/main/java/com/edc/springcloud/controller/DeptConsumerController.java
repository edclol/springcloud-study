package com.edc.springcloud.controller;
/**
 * Created by JessePinkMan on 2020/9/13 11:05
 */

import com.edc.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * JessePinkMan
 */
@Controller
@ResponseBody
public class DeptConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    private final String url = "http://localhost:8001";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        System.out.println(url+"/dept/get/"+id);
        System.out.println(restTemplate);
        Dept object = restTemplate.getForObject(url + "/dept/get/" + id, Dept.class);
        System.out.println(object);
        return object;
    }

    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return restTemplate.postForObject(String.format("%s/dept/add", url),dept,Boolean.class);
    }


    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(url+"/dept/list/",List.class);
    }




}
