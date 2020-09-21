package com.example.redis.exception;

import com.example.redis.common.ResponseObj;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyControllerAdvice {

    /**
     * 全局异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseObj<String> errorHandle(Exception e) {

        ResponseObj<String> responseObj = new ResponseObj();
        responseObj.setRetCode(ResponseObj.CODE_FAILED);
        responseObj.setRetMsg(e.getMessage());

        return responseObj;
    }

    @ExceptionHandler(value = BusinessException.class)
    public Map<String, Object> errorHandle(BusinessException e) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", e.getCode());
        map.put("msg", e.getMsg());
        return map;
    }
}
