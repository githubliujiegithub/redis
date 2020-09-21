package com.example.redis.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//自定义异常
public class BusinessException extends RuntimeException {

    private String code;
    private String msg;
}
