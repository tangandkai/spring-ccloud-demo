package com.tang.orderH.controller;

import com.tang.orderH.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_info_ok(@PathVariable("id") Integer id){
        String result = paymentService.payment_ok(id);
        System.out.println("************result***********"+result+"\t"+"port: "+port);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payment_time_out(@PathVariable("id") Integer id){
        String result = paymentService.payment_time_out(id);
        System.out.println("************result***********"+result+"\t"+"port: "+port);
        return result;
    }

    @GetMapping("/payment/hystrix/circuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        System.out.println("************result***********"+result+"\t"+"port: "+port);
        return result;
    }
}
