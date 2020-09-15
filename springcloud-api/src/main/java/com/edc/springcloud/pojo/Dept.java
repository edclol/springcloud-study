package com.edc.springcloud.pojo;
/**
 * Created by JessePinkMan on 2020/9/12 14:53
 */

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * JessePinkMan
 */

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    private long deptno;
    private String dname;
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }

}
