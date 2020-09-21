package com.example.redis.study.easyexcel;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountNumberDao {

    int insert(AccountNumber accountNumber);
}
