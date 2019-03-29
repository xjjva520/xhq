package com.xhq.xhqservice.client.fallback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.xhq.xhqservice.client.RedisClient;

@Component
public class RedisClientFallBack implements RedisClient{
	
	private final static Logger logger = LogManager.getLogger(RedisClientFallBack.class);
	
	@Override
	public void set(String key, String value, String traceId) {
		logger.info("redis service now is not ok,please check redis-service key={}",key);
	}

	@Override
	public String get(String key, String traceId) {
		logger.info("redis service now is not ok,please check redis-service key={}",key);
		return null;
	}

}
