package com.tang.cloud.order.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentServiceFallBack implements PaymentService{
    @Override
    public String paymentSql(Integer id) {
        return "paymentSql...........fallback";
    }
}
