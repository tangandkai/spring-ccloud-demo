package com.tang.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAilibabaPayment9005Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAilibabaPayment9005Application.class, args);
	}

}
