package com.tang.cloud.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAilibabaSentinel8401Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAilibabaSentinel8401Application.class, args);
    }

}
