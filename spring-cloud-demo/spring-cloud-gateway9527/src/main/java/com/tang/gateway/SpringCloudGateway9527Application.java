package com.tang.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudGateway9527Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGateway9527Application.class, args);
	}

}
