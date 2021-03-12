package com.tang.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAilibabaOrder83Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAilibabaOrder83Application.class, args);
    }

}
