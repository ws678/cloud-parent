package com.sdkj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wangshuo
 * @Date 2022/5/22, 11:20
 * Please add a comment
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    private static final String url = "http://cloud-payment-service";
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getPaymentPort")
    @ResponseBody
    public String getUrl() {
        return restTemplate.getForObject(url + "/payment/getConsul", String.class);
    }
}
