package com.xhq.xhqinterface.client.xhqservice.fallbak;

import org.springframework.stereotype.Component;

import com.xhq.xhqinterface.client.xhqservice.IStudentClient;

@Component
public class StudentFallBack implements IStudentClient {

	@Override
	public String findByName(String name, String traceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findBykey(String key, String traceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
