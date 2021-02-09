package com.tang.payment8004.service;


import com.tang.interfaces.bean.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById( Long id);
}
