package com.example.redis.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = -114290720029970618L;

    private Integer id;

    private String name;

    private String password;
}
