package com.crrchz.eurekaone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaoneApplication.class, args);
    }

}

