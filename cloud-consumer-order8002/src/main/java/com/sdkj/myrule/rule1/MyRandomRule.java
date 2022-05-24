package com.sdkj.myrule.rule1;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wangshuo
 * @Date 2022/5/22, 15:31
 * 自定义随机策略
 */
/*@Configuration
public class MyRandomRule {

    //随机策略
    @Bean
    public IRule myRule(){

        return new RandomRule();
    }
}*/
