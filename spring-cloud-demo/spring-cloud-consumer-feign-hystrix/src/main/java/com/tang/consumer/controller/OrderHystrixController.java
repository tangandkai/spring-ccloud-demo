package com.tang.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tang.consumer.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")//全局兜底方案设置
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
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
//    })
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String payment_time_out(@PathVariable("id") Integer id){
        String result = paymentHystrixService.payment_time_out(id);
        System.out.println("************result***********"+result+"\t"+"port: "+port);
        return result;
    }
    public String paymentTimeoutFallbackHandler(@PathVariable("id") Integer id){
        return "我是消费者 系统繁忙，稍后再试....,id: 8105 "+"\t"+"O(_-_)O哈哈 耗时(秒): ";
    }

    public String paymentGlobalFallbackMethod(){
        return "全局兜底 系统繁忙，稍后再试....,id: 8105 "+"\t"+" ";
    }
}
