package com.tang.cloud.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tang.cloud.order.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 熔断
 */
@RestController
public class CircleBreakController {
    @Value("${service-url.nacos-user-service}")
    private String URL;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;


    //@SentinelResource(value = "fallback")
    //@SentinelResource(value = "fallback",fallback = "handlerFallback")//fallback负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler")//blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback",blockHandler = "blockHandler",fallback = "handlerFallback")
    @GetMapping(value = "/consumer/fallback/{id}")
    public String fallback(@PathVariable("id") Long id){
        if (id==4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常......");
        }
        return restTemplate.getForObject( URL + "/paymentSQL/" + id, String.class );
    }

    public String handlerFallback(@PathVariable("id") Long id,Throwable e){
        return e.getMessage()+"\t"+"handlerFallback";
    }

    public String blockHandler(@PathVariable("id") Long id, BlockException e){
        return e.getMessage()+"\t"+"blockHandler";
    }

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public String paymentSQL(@PathVariable("id") Integer id){
        return paymentService.paymentSql(id);
    }
}
