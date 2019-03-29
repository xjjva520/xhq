package com.xhq.xhqservice.service.impl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xhq.xhqservice.client.RedisClient;
import com.xhq.xhqservice.controller.StudentController;
import com.xhq.xhqservice.entity.Student;
import com.xhq.xhqservice.repository.mongodb.StudentRepository;
import com.xhq.xhqservice.service.IDealDataService;

@Service
public class StudentServiceImpl implements IDealDataService<Student>{
	private final static Logger logger = LogManager.getLogger(StudentController.class);
	
	@Autowired
	private StudentRepository stuRespo;
	
	@Autowired
	private RedisClient redisclient;

	@Override
	public Student findById(String Id,String traceId) {
		String string = redisclient.get(Id, traceId);
		Student student = JSON.parseObject(string, Student.class);
		return student;
	}

	@Override
	public Student findByName(String name,String traceId) {
		 logger.info("get student from mongodb keywords = {}",name);
		 Student student = stuRespo.findByName(name);
		 logger.info("get student from mongodb Student = {}",student);
		 redisclient.set(student.getId(), JSON.toJSONString(student), traceId);
		 return student;
	}

}
