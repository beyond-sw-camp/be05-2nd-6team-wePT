package org.encore.apartment.community.global.config;

import java.time.Duration;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RedisUtil {

    //Redis에 접근하기 위한 Spring의 Redis 템플릿 클래스
    private final StringRedisTemplate redisTemplate;

    //지정된 키(key)에 해당하는 데이터를 Redis에서 가져오는 메서드
    public String getData(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    //지정된 키(key)에 값을 저장하는 메서드
    public void setData(String key, String value) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    //지정된 키(key)에 값을 저장하고, 지정된 시간(duration) 후에 데이터가 만료되도록 설정하는 메서드
    public void setDataExpire(String key, String value, long duration) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        Duration expireDuration = Duration.ofSeconds(duration);
        valueOperations.set(key, value, expireDuration);
    }

    //지정된 키(key)에 해당하는 데이터를 Redis에서 삭제하는 메서드
    public void deleteData(String key) {
        redisTemplate.delete(key);
    }

}