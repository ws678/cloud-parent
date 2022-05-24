package com.sdkj.controller;

import com.sdkj.myrule.rule3.LoadBalancer;
import com.sdkj.response.CommonReturnType;
import com.sdkj.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private PaymentFeignService paymentFeignService;

    @RequestMapping("/getPaymentById")
    @ResponseBody
    public CommonReturnType getById(Long id) {
        //不要忘记把参数传过去
        return restTemplate.getForObject(url + "/payment/findById/?id=" + id, CommonReturnType.class);
    }

    @RequestMapping("/getPort")
    @ResponseBody
    public String getPort() {

        return restTemplate.getForObject(url + "/payment/getPort", String.class);
    }

    @RequestMapping("/getLBPort")
    @ResponseBody
    public String getLbPort() {

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() == 0)
            return null;
        ServiceInstance instance = loadBalancer.getInstance(instances);
        return restTemplate.getForObject(instance.getUri() + "/payment/getPort", String.class);
    }

    //使用open feign
    @GetMapping("/findPaymentById/{id}")
    @ResponseBody
    public CommonReturnType findPaymentById(@PathVariable Long id){

        return paymentFeignService.findPaymentById(id);
    }
}
