package com.xhq.xhqinterface.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xhq.xhqinterface.client.xhqservice.IStudentClient;

@RestController
public class StudentController {
   
	@Autowired
	private IStudentClient studentClient;
	
	@RequestMapping("getStudentByName")
	public String getStudentByName(String name,HttpServletRequest req) {
		String traceId = (String) req.getAttribute("traceId");
		return studentClient.findByName(name,traceId);
	}
	
	@RequestMapping("getStudentById")
	public String getStudentByKey(String key,HttpServletRequest req) {
		String traceId = (String) req.getAttribute("traceId");
		return studentClient.findBykey(key,traceId);
	}
}
