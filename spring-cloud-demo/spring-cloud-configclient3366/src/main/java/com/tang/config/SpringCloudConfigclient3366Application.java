package com.tang.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudConfigclient3366Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigclient3366Application.class, args);
    }

}
