package com.example.repository;

import com.example.Store;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StoreRepository {

    private RedisTemplate<Integer, Store> redisTemplate;
    private HashOperations hashOperations;

    public StoreRepository(RedisTemplate<Integer, Store> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    public void save(Store store) {
        hashOperations.put("store-cache", store.getId(), store);
    }

    public Map<Integer, Store> findAll() {
        return hashOperations.entries("store-cache");
    }

    public Store findById(Integer id) {
        return (Store) hashOperations.get("store-cache", id);
    }

    public void update(Store store) {
        save(store);
    }

    public void delete(Integer id) {
        hashOperations.delete("store-cache", id);
    }
}
