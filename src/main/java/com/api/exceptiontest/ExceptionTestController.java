package com.api.exceptiontest;

import com.api.feigntest.TestDto;
import com.api.global.ErrorCode;
import com.api.global.error.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/exception")
public class ExceptionTestController {

    @GetMapping("/test")
    public TestDto feignTest() {
        throw  new RuntimeException("aaaaaa");
//        return TestDto.builder().name("aaa").age(22).build();
    }

    @GetMapping("/bind-exception-test")
    public String bindExceptionTest(@Valid ExceptionTestDto exceptionTestDto){
        return "ok";
    }

    @GetMapping("/type-excetpion-test")
    public String typeMissMatchException(TestEnum testEnum) {
        return "ok";
    }

    @GetMapping("/bussiness-exception-test")
    public String businessExceptionTest(String isError){
        if ("true".equals(isError)) {
            throw new BusinessException(ErrorCode.TEST);
        }
        return "ok";
    }

    @GetMapping("/exception-test")
    public String exceptionTest(String isError){
        if ("true".equals(isError)) {
            throw new IllegalStateException("예외 테스트");
        }
        return "ok";
    }

}
