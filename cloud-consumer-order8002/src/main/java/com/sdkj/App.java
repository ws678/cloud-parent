package com.sdkj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author wangshuo
 * @Date 2022/5/19, 19:46
 * Please add a comment
 */
@EnableEurekaClient/*注意这个是client和提供者server不一样*/
@SpringBootApplication(scanBasePackages = {"com.sdkj"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
