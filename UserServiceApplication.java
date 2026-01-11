package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {
    private static final Logger myLoggerInstance = LoggerFactory.getLogger(UserServiceApplication.class);
    
    public static void main(String[] myArgs) {
        myLoggerInstance.info("Starting User Service Application with Spring Cloud support");
        SpringApplication.run(UserServiceApplication.class, myArgs);
    }
}