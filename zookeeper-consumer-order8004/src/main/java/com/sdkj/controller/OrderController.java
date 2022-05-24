package com.sdkj.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wangshuo
 * @Date 2022/5/21, 19:30
 * Please add a comment
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    private static final String url = "http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getPaymentZk")
    @ResponseBody
    public String getPaymentZk() {

        return restTemplate.getForObject(url + "/payment/getZk", String.class);
    }

    @GetMapping(value = "/hystrix/timeout")
    // @HystrixCommand 支持服务降级
    @HystrixCommand(fallbackMethod = "paymentDemoteFallback")
    @ResponseBody
    public String paymentTimeout(Integer id) {
        //int n = 10/0;
        return restTemplate.getForObject(url + "/payment/hystrix/timeout?id="+id, String.class);
    }

    //降级回调方法
    public String paymentDemoteFallback(Integer id){

        return "消费者：对方支付系统繁忙，请稍后再试，ID == "+id;
    }
}
