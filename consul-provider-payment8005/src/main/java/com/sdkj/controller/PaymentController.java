package com.sdkj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @Author wangshuo
 * @Date 2022/5/22, 11:08
 * Please add a comment
 */
@Controller
@RequestMapping(value = "/payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/getConsul")
    @ResponseBody
    public String getPort() {
        return "server Port: " + port + UUID.randomUUID();
    }
}
