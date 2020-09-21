package com.example.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author chengliujie
 * @date 2020-04-08 9:30
 * @description:
 */

@Component
public class CacheHelper {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 普通缓存获取
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> T get(String key) {

        return key == null ? null : (T) redisTemplate.opsForValue().get(appendSpacePrefix(key));
    }

    public void set(String key, Object value) {

        redisTemplate.opsForValue().set(appendSpacePrefix(key), value);
    }

    private String appendSpacePrefix(String key) {

        return "opf_system:" + key;
    }
}
