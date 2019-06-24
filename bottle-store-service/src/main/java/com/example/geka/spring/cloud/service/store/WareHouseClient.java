package com.example.geka.spring.cloud.service.store;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("warehouse-service")
@RequestMapping
public interface WareHouseClient {

    @GetMapping("/{bottleId}")
    Bottle findBottle(@PathVariable("bottleId") Long bottleId);

}
