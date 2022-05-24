package com.sdkj.myrule.rule3;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wangshuo
 * @Date 2022/5/22, 21:43
 * Please add a comment
 */
@Component
public class MyLB implements LoadBalancer{

    //轮询核心实现
    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {
        int index = getAtomicInteger() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //获取下一个值（线程安全并对最大值做了处理）
    public final int getAtomicInteger() {
        int current;
        int next;
        do {
            current = atomicInteger.getAndIncrement();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (atomicInteger.compareAndSet(current,next));
        System.out.println("next = " + next);
        return next;
    }
}
