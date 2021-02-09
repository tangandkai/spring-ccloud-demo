package com.tang.payment8004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //该注解用于向consule或者zookeeper作为注册中心时注册服务
public class SpringCloudPayment8004Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudPayment8004Application.class, args);
	}

}
