package com.tang.consumer.controller;

import com.tang.consumer.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String payment_info_ok(@PathVariable("id") Integer id){
        String result = paymentHystrixService.payment_info_ok(id);
        System.out.println("************result***********"+result+"\t"+"port: "+port);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String payment_time_out(@PathVariable("id") Integer id){
        String result = paymentHystrixService.payment_time_out(id);
        System.out.println("************result***********"+result+"\t"+"port: "+port);
        return result;
    }

}
