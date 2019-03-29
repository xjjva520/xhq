package com.xhq.xhqservice.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xhq.xhqservice.entity.Student;


public interface StudentRepository extends MongoRepository<Student,String>  {
	
	public Student findByName(String name);
   
}
