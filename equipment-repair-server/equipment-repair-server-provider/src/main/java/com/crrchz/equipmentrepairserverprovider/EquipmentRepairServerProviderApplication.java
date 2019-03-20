package com.crrchz.equipmentrepairserverprovider;

import com.crrchz.userserverapi.service.UserFeignApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = UserFeignApi.class)
public class EquipmentRepairServerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipmentRepairServerProviderApplication.class, args);
    }

}

