package com.edc.springcloud.service;

import com.edc.springcloud.pojo.Dept;

import java.util.List;

/**
 * Created by JessePinkMan on 2020/9/12 15:31
 */
public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept queryById(Long id);
    public List<Dept> queryAll();
}
