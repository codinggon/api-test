package com.api.feigntest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8080", name = "helloClient")
public interface HelloClient {

    @GetMapping(value = "/api/exception/test", consumes = "application/json")
    TestDto feignTest();

}
