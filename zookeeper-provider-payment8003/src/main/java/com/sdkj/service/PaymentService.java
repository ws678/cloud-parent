package com.sdkj.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author wangshuo
 * @Date 2022/5/23, 22:02
 * Please add a comment
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName()
                + "，paymentInfo_OK，ID == " + id;
    }


    // fallbackMethod: 设置HystrixCommand服务降级所使用的方法名称，注意该方法需要与原方法定义在同一个类中，并且方法签名也要一致
    // commandProperties: 设置HystrixCommand属性，如：断路器失败百分比、断路器时间容器大小等
    // 设置断路器超时降级策略，时间3000毫秒超时
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_Timeout(Integer id) {
        int second = 5000;
        try {
            // 休眠5000毫秒
            TimeUnit.MILLISECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 异常
//        int n = 10/0;//测试异常降级
        return "线程池：" + Thread.currentThread().getName()
                + "，paymentInfo_Timeout，ID == " + id
                + "，耗时" + second + "毫秒";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        String result = "线程池：" + Thread.currentThread().getName()
                + "，paymentInfo_TimeoutHandler，ID == " + id;
        return result;
    }
}
