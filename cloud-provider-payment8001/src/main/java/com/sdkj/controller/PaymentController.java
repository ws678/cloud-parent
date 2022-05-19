package com.sdkj.controller;

import com.sdkj.dataobject.PaymentDO;
import com.sdkj.error.BusinessException;
import com.sdkj.error.EnumBusinessError;
import com.sdkj.response.CommonReturnType;
import com.sdkj.service.PaymentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author wangshuo
 * @Date 2022/5/19, 9:08
 * Please add a comment
 */
@Controller
@RequestMapping(value = "/payment")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class PaymentController extends BaseController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/findById")
    @ResponseBody
    public CommonReturnType findById(Long id) throws BusinessException {

        if (StringUtils.isEmpty(id.toString()))
            throw new BusinessException(EnumBusinessError.REGISTER_OTP_ERROR);//参数不合法
        PaymentDO payment = paymentService.getPaymentById(id);
        return CommonReturnType.create(payment);
    }
}
