package com.tang.orderH.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String payment_ok(int id){
        return "线程池：  "+Thread.currentThread().getName()+"payment_ok,id: "+"\t"+"O(n_n)O哈哈";
    }

    public String payment_time_out(int id){
        int num = 3;
        try {
            Thread.sleep(num*1000);
        }catch (InterruptedException e){
        }
        return "线程池：  "+Thread.currentThread().getName()+"payment_time_out,id: "+"\t"+"O(n_n)O哈哈 耗时(秒): "+num;
    }
}
