package com.sdkj.controller;

import com.sdkj.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @Author wangshuo
 * @Date 2022/5/21, 19:14
 * Please add a comment
 */
@Controller
@RequestMapping(value = "/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/getZk")
    @ResponseBody
    public String getPaymentZk(){

        return "spring cloud with zookeeper：" + serverPort + "\t" + UUID.randomUUID();
    }

    //测试线程不降级
    @RequestMapping(value = "/hystrix/ok")
    @ResponseBody
    public String getHystrixOk(Integer id){

        return paymentService.paymentInfo_OK(id);
    }

    //测试超时降级
    @RequestMapping(value = "/hystrix/timeout")
    @ResponseBody
    public String getHystrixTimeout(Integer id){

        return paymentService.paymentInfo_Timeout(id);
    }
}
