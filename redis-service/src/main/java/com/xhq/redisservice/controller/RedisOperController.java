package com.xhq.redisservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xhq.redisservice.service.RedisOperationService;

@RestController
public class RedisOperController {
	@Autowired
	private RedisOperationService service;
	
	@RequestMapping(value="setRedis",method=RequestMethod.GET)
	public void set(String key,String value,String traceId) {

		service.setRedis(key,value);
	}
	
	@RequestMapping(value="getRedis",method=RequestMethod.GET)
	public String get(String key,String traceId) {	
		String str = service.getRedis(key);
		return str;
	}

	
}
