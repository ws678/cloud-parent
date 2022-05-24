package com.sdkj.service;

import com.sdkj.response.CommonReturnType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author wangshuo
 * @Date 2022/5/23, 9:35
 * 使用open feign调用消费者
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/findById?id={id}")
    public CommonReturnType findPaymentById(@PathVariable Long id);
}
