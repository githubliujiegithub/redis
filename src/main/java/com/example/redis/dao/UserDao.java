package com.example.redis.dao;

import com.example.redis.model.dbo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    void insertUser(User user);
}
