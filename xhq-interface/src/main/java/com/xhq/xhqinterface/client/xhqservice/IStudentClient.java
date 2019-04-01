package com.xhq.xhqinterface.client.xhqservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xhq.xhqinterface.client.xhqservice.fallbak.StudentFallBack;


@FeignClient(name = "${feign.xhq-service.name}",url="${feign.xhq-service.url}", fallback = StudentFallBack.class)
public interface IStudentClient {
    
	@RequestMapping(value="student/findByName", method=RequestMethod.GET)
	public String findByName(@RequestParam("name") String name,@RequestParam("traceId") String traceId);
	
	@RequestMapping(value="student/findById", method=RequestMethod.GET)
	public String findBykey(@RequestParam("key") String key,@RequestParam("traceId") String traceId);
}
