package com.sdkj.myrule.rule3;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author wangshuo
 * @Date 2022/5/22, 21:41
 * Please add a comment
 */
public interface LoadBalancer {

    ServiceInstance getInstance(List<ServiceInstance>serviceInstances);
}
