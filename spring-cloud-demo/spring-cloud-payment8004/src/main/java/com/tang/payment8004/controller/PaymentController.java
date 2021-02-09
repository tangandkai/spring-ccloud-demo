package com.tang.payment8004.controller;

import com.tang.interfaces.bean.CommonResult;
import com.tang.interfaces.bean.Payment;
import com.tang.payment8004.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******查询结果********"+payment);
        if (payment!=null){
            return new CommonResult<>(200,"查询成功",payment);
        }else {
            return new CommonResult<>(444,"没有对应记录，查询id："+id);
        }
    }

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*********插入结果*********"+result);
        if (result>0){
            return new CommonResult<>(200,"插入数据库成功",result);
        }else {
            return new CommonResult<>(444,"插入数据库失败");
        }
    }
}
