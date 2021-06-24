package com.tang.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringCloudAilibabaOrder84Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAilibabaOrder84Application.class, args);
	}
}
