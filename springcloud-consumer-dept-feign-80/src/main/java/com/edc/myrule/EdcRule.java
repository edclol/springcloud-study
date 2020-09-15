package com.edc.myrule;
/**
 * Created by JessePinkMan on 2020/9/13 20:42
 */

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * JessePinkMan
 */
public class EdcRule extends AbstractLoadBalancerRule{


    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    private Server choose(ILoadBalancer lb, Object key) {
        List<Server> servers = lb.getReachableServers();
        System.out.println("----");
        servers.forEach(System.out::println);
        System.out.println("----");
        return servers.get(1);
    }
}
