package com.tang.consumer.service;

import org.springframework.stereotype.Component;

/**
 *
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String payment_info_ok(Integer id) {
        return "-------PaymentFallbackService fall back-paumentinfo_ok";
    }

    @Override
    public String payment_time_out(Integer id) {
        return "-------PaymentFallbackService fall back-payment_time_out";
    }
}
