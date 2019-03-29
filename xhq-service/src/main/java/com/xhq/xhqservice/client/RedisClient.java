package com.xhq.xhqservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xhq.xhqservice.client.fallback.RedisClientFallBack;

@FeignClient(name = "${feign.redis-service.name}", url = "${feign.redis-service.url}", fallback = RedisClientFallBack.class)
public interface RedisClient {
	/**
	 * set
	 * @param key
	 * @param value
	 * @param traceId 跟踪Id
	 */
	@RequestMapping(value="setRedis",method=RequestMethod.GET)
	public void set(@RequestParam("key") String key,@RequestParam("value")String value,@RequestParam("traceId") String traceId);
	
	/**
	 * 获取
	 * @param key
	 * @param traceId
	 * @return
	 */
	@RequestMapping(value="getRedis",method=RequestMethod.GET)
	public String get(@RequestParam("key") String key,@RequestParam("traceId") String traceId);

}
