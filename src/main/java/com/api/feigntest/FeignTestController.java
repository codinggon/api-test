package com.api.feigntest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FeignTestController {

    private final HelloClient helloClient;

    @GetMapping("/feign-test")
    public ResponseEntity<TestDto> healthCheckTest(){
        TestDto testDto = helloClient.feignTest();
        return ResponseEntity.ok(testDto);
    }




}
