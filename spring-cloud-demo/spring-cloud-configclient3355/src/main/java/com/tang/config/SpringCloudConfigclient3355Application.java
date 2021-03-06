package com.tang.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudConfigclient3355Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigclient3355Application.class, args);
    }

}
