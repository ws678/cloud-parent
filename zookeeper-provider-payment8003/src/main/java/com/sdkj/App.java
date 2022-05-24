package com.sdkj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author wangshuo
 * @Date 2022/5/21, 19:11
 * Please add a comment
 */
//服务发现
@EnableDiscoveryClient
//启用熔断器
@EnableCircuitBreaker
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
