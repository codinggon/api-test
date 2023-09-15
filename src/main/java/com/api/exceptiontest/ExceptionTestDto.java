package com.api.exceptiontest;

import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
public class ExceptionTestDto {

    @NotBlank(message = "해당 값 필수")
    private String value1;

    @Max(value = 10, message = "최대 입력값은 10입니다.")
    private Integer value2;






}
