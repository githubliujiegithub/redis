package com.example.redis.study.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class AccountNumber {

    private Integer id;

    @ExcelProperty(value = "姓名", index = 1)
    private String name;

    @ExcelProperty(value = "电话", index = 2)
    private String phone;

    @ExcelProperty(value = "邮箱", index = 3)
    private String email;
}
