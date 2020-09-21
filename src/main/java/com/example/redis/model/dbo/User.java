package com.example.redis.model.dbo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = -561876720017011277L;

    private Integer id;

    private String name;

    private String password;
}
