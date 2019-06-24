package com.example.geka.spring.cloud.service.warehouse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping
public class WareHouseApplication {

    private final Logger logger = LoggerFactory.getLogger(WareHouseApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WareHouseApplication.class, args);
    }

    final private List<Bottle> bottleList = Arrays.asList(
            new Bottle(1L, "Butilka odin"),
            new Bottle(2L, "Butilka dva"),
            new Bottle(3L, "Butilka tri"),
            new Bottle(4L, "Butilka 4etyre")
    );

    @GetMapping
    public List<Bottle> findAllBottles() {
        return bottleList;
    }

    @GetMapping("{bottleId}")
    public Bottle findBottle(@PathVariable Long bottleId) {
        logger.warn("someone ask me about bottle with id " + bottleId);
        return bottleList.stream()
                .filter(bottle -> bottle.getId().equals(bottleId))
                .findFirst()
                .orElse(null);
    }
}
