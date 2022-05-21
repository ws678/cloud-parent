package com.sdkj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author wangshuo
 * @Date 2022/5/18, 9:24
 * Please add a comment
 */
//标识为EurekaServer
@EnableEurekaServer
@SpringBootApplication(scanBasePackages = {"com.sdkj"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
