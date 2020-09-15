package com.edc.springcloud.dao;

import com.edc.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by JessePinkMan on 2020/9/12 15:21
 */
@Mapper
@Repository
@MapperScan
public interface DeptDao {

    public boolean addDept(Dept dept);
    public Dept queryById(Long id);
    public List<Dept> queryAll();

}
