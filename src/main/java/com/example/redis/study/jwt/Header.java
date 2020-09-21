package com.example.redis.study.jwt;

public enum Header {

    SM3("sm3", "国密3加密算法，其算法不可逆，类似MD5"),
    SM4("sm4", "国密4加密算法，对称加密"),
    AES("aes", "AES加密算法，对称加密");

    private String code;

    private String details;

    Header(String code, String details) {
        this.code = code;
        this.details = details;
    }
}
