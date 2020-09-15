package com.edc.springcloud.service;
/**
 * Created by JessePinkMan on 2020/9/14 21:16
 */

import com.edc.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * JessePinkMan
 */
@Component //别忘了把它扫描进去
public class DeptClientServiceFallBack implements FallbackFactory {


    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService(){
            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptno(id).setDname("服务使用feign降级了");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
