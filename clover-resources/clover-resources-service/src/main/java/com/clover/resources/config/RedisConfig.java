package com.clover.resources.config;


import com.clover.common.cache.Cache;
import com.clover.resources.common.util.RedisCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;


/**
 * @ClassName: RedisConfig
 * @Description: Redis配置类
 * @Author: Clover
 * @Date: 2021.03.27
 * Version: 1.0
 */
@Configuration
public class RedisConfig {

    @Bean
    public Cache cache(StringRedisTemplate stringRedisTemplate){
        return new RedisCache(stringRedisTemplate);
    }
}
