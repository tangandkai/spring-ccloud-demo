package com.tang.orderH.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String payment_ok(int id){
        return "线程池：  "+Thread.currentThread().getName()+"payment_ok,id: "+"\t"+"O(n_n)O哈哈";
    }

    @HystrixCommand(fallbackMethod = "payment_time_out_handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String payment_time_out(int id){
        int num = 4;
        //int i = 10/0;
        try {
            Thread.sleep(num*1000);
        }catch (InterruptedException e){
        }
        return "线程池：  "+Thread.currentThread().getName()+"payment_time_out,id: "+"\t"+"O(n_n)O哈哈 耗时(秒): "+num;
    }

    public String payment_time_out_handler(int id){
        int num = 0;
        return "线程池：  "+Thread.currentThread().getName()+"    系统繁忙，稍后再试....,id: "+"\t"+"O(_-_)O哈哈 耗时(秒): "+num;
    }
}
