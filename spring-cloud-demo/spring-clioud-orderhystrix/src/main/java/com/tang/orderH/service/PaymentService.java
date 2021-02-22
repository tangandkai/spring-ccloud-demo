package com.tang.orderH.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    //================服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到该阈值时跳匝
    })
    public String paymentCircuitBreaker(int id){
        if (id<0){
            throw new RuntimeException("***********************id 不能为负数");
        }
        return Thread.currentThread().getName()+"\t"+" 调用成功，流水号： "+ UUID.randomUUID();
    }

    public String paymentCircuitBreaker_fallback(int id){
        return "id 不能为负数，请稍后再试， id: "+id;
    }
}
