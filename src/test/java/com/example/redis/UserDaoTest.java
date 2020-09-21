package com.example.redis;

import com.example.redis.dao.UserDao;
import com.example.redis.model.dbo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void insertTest() {
        User user = new User();
        user.setName("cheng");
        user.setPassword("123");
        userDao.insertUser(user);
    }
}
