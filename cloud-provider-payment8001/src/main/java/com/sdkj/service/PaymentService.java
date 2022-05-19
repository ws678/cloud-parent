package com.sdkj.service;

import com.sdkj.dataobject.PaymentDO;

/**
 * @Author wangshuo
 * @Date 2022/5/19, 8:44
 * Please add a comment
 */
public interface PaymentService {

    //新增支付信息
    public int insert(PaymentDO paymentDO);

    //根据ID查询支付信息
    public PaymentDO getPaymentById(Long id);
}
