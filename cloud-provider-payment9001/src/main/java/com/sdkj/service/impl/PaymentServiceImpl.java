package com.sdkj.service.impl;

import com.sdkj.dao.PaymentDOMapper;
import com.sdkj.dataobject.PaymentDO;
import com.sdkj.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author wangshuo
 * @Date 2022/5/19, 8:47
 * Please add a comment
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDOMapper paymentDOMapper;

    @Override
    public int insert(PaymentDO paymentDO) {
        return paymentDOMapper.insertSelective(paymentDO);
    }

    @Override
    public PaymentDO getPaymentById(Long id) {
        return paymentDOMapper.selectByPrimaryKey(id);
    }
}
