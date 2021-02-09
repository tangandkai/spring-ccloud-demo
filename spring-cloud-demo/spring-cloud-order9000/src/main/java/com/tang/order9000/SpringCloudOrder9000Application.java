package com.tang.order9000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudOrder9000Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOrder9000Application.class, args);
	}
}
