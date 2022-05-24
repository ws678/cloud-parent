package com.sdkj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Author wangshuo
 * @Date 2022/5/21, 19:30
 * Please add a comment
 */
//开启熔断器（这个注解包含了@EnableCircuitBreaker）
@EnableHystrix
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
