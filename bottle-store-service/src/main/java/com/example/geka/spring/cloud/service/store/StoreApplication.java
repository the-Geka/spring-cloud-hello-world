package com.example.geka.spring.cloud.service.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
@RequestMapping("/")
public class StoreApplication {

    private final WareHouseClient wareHouseClient;
    private final Logger logger = LoggerFactory.getLogger(StoreApplication.class);


    public StoreApplication(WareHouseClient wareHouseClient) {
        this.wareHouseClient = wareHouseClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    @GetMapping
    public Bottle getRandomBottle() {
        logger.warn("someone ask me about book random bottle, i will ask WareHouse");
        Bottle bottle = wareHouseClient.findBottle(ThreadLocalRandom.current().nextLong(1L, 4L));
        logger.warn("WareHouse service answered me, it is bottle with title " + bottle.getTitle());
        return bottle;
    }

}
