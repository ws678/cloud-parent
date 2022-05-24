package com.sdkj.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wangshuo
 * @Date 2022/5/23, 19:08
 * 配置feign日志级别
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        /*
            Feign有一下日志级别：
　　          NONE：默认的，不显示任何日志
　　          BASIC：仅记录请求方法、URL、响应状态码及执行时间
　　          HEADERS：出了BASIC中定义的信息之外，还有请求和响应的头信息
        　　  FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元素
         */
        return Logger.Level.BASIC;
    }
}
