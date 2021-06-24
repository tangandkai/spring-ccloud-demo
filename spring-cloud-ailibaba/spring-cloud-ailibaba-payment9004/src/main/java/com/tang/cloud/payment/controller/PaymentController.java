package com.tang.cloud.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String SERVER_PORT;

    public static HashMap<Integer,String> hashMap = new HashMap<>();
    static {
        hashMap.put(1,"一号商品");
        hashMap.put(2,"二号商品");
        hashMap.put(3,"三号商品");
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public String paymentSQL(@PathVariable("id") Integer id){
        return hashMap.get(id)+"\t"+SERVER_PORT;
    }
}
