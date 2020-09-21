package com.example.redis.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author chengliujie
 * @date 2020-04-08 9:07
 * @description:
 */
@Configuration
@EnableCaching
public class RedisConfig {

    private final static StringRedisSerializer STRING_REDIS_SERIALIZER = new StringRedisSerializer();

    private final static GenericJackson2JsonRedisSerializer GENERIC_JACKSON_2_JSON_REDIS_SERIALIZER = new GenericJackson2JsonRedisSerializer();

    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(STRING_REDIS_SERIALIZER);
        redisTemplate.setValueSerializer(GENERIC_JACKSON_2_JSON_REDIS_SERIALIZER);
        return redisTemplate;

    }

}
