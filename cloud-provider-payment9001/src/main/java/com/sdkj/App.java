package com.sdkj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author wangshuo
 * @Date 2022/5/18, 16:37
 * Please add a comment
 */
@SpringBootApplication(scanBasePackages = {"com.sdkj"})
@EnableEurekaClient
//启用服务发现
@EnableDiscoveryClient
@MapperScan("com.sdkj.dao")//扫描dao添加Mapper
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
