package com.sdkj;

import com.sdkj.myrule.rule2.MyBalancedRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author wangshuo
 * @Date 2022/5/19, 19:46
 * Please add a comment
 */
//标识为eureka client端
@EnableEurekaClient/*注意这个是client和提供者server不一样*/
@SpringBootApplication(scanBasePackages = {"com.sdkj"})
//开启服务发现
@EnableDiscoveryClient
//开启feign客户端
@EnableFeignClients
//使用自定义的Ribbon规则
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyBalancedRule.class)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
