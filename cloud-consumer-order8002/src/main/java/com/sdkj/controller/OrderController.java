package com.sdkj.controller;

import com.sdkj.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wangshuo
 * @Date 2022/5/19, 19:52
 * Please add a comment
 */
@Controller
@RequestMapping(value = "/order")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class OrderController {

    private static final String url = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/getPaymentById")
    @ResponseBody
    public CommonReturnType getById(Long id) {
        //不要忘记把参数传过去
        return restTemplate.getForObject(url + "/payment/findById/?id=" + id, CommonReturnType.class);
    }
}
