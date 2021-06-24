package com.tang.cloud.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentServiceFallBack.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public String paymentSql(@PathVariable("id") Integer id);
}
