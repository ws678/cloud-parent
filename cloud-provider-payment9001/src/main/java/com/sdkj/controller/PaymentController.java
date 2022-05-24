package com.sdkj.controller;

import com.sdkj.dataobject.PaymentDO;
import com.sdkj.error.BusinessException;
import com.sdkj.error.EnumBusinessError;
import com.sdkj.response.CommonReturnType;
import com.sdkj.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author wangshuo
 * @Date 2022/5/19, 9:08
 * Please add a comment
 */
@Controller
@RequestMapping(value = "/payment")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
@Slf4j
public class PaymentController extends BaseController {

    @Autowired
    PaymentService paymentService;
    //注入服务发现
    @Autowired
    DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/findById")
    @ResponseBody
    public CommonReturnType findById(Long id) throws BusinessException {

        if (StringUtils.isEmpty(id.toString()))
            throw new BusinessException(EnumBusinessError.REGISTER_OTP_ERROR);//参数不合法
        PaymentDO payment = paymentService.getPaymentById(id);
        return CommonReturnType.create(payment);
    }

    @RequestMapping(value = "/getDiscovery")
    @ResponseBody
    public Object getDiscovery() {

        //获取服务列表
        for (String service : discoveryClient.getServices()) {
            log.info("发现service：" + service);
        }
        //获取服务实例集合
        for (ServiceInstance instance : discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE")) {
            log.info("发现服务CLOUD-PAYMENT-SERVICE：" +
                    " serviceId = " + instance.getServiceId() +
                    " host = " + instance.getHost() +
                    " port = " + instance.getPort() +
                    " uri = " + instance.getUri());
        }
        return this.discoveryClient;
    }

    @RequestMapping("/getPort")
    @ResponseBody
    public String getPort() {
        return "server port = " + port;
    }
}
