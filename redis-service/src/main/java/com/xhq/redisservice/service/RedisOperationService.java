package com.xhq.redisservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhq.redisservice.factory.JedisSentinelPoolFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

@Service
public class RedisOperationService {
	
	@Autowired
	private JedisSentinelPoolFactory jedisPoolsFactory;
    
    public void setRedis(String key,String value) {
    
    	JedisSentinelPool sentinelPool = jedisPoolsFactory.getSentinelPool(key);
    	
    	Jedis jedis = sentinelPool.getResource();
        
    	jedis.set(key, value);

        jedis.close();
        
    }
    
    
    public String getRedis(String key) {
        
    	JedisSentinelPool sentinelPool = jedisPoolsFactory.getSentinelPool(key);
    	
    	Jedis jedis = sentinelPool.getResource();
        
    	String value = jedis.get(key);

        jedis.close();
        
        return value;
    }
}
