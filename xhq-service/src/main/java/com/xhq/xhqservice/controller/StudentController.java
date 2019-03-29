package com.xhq.xhqservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xhq.xhqservice.entity.Music;
import com.xhq.xhqservice.entity.Student;
import com.xhq.xhqservice.service.IDealDataService;

@RestController
@RequestMapping("student")
public class StudentController {
		
	@Autowired
	private IDealDataService<Student> stuImpl;
	
	@Autowired
	private IDealDataService<Music> musciServiceImpl;
	
	/**
	 * 通过学生名称查找，然后存入redis
	 * @param name
	 * @param traceId
	 * @return
	 */
	@RequestMapping(value="findByName", method=RequestMethod.GET)
	@ResponseBody
	public Student testMongodb(String name,String traceId) {
		Student stu = stuImpl.findByName(name,traceId);
		return stu;
	}
	
	/**
	 * 查redis中得值
	 * @param key
	 * @param traceId
	 * @return
	 */
	@RequestMapping(value="findById", method=RequestMethod.GET)
	@ResponseBody
	public Student testSolr(String key,String traceId) {
		Student stu = stuImpl.findById(key, traceId);
		return stu;
	}
}
