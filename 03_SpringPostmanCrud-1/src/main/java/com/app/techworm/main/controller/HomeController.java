package com.app.techworm.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.techworm.main.model.Student;
import com.app.techworm.main.serviceimplemenattion.StudentServiceImpl;

@RestController
@CrossOrigin
public class HomeController {

	@Autowired
	private StudentServiceImpl serviceImpl;
	
	@PostMapping(value = "saveStudent")
	public Student saveStudent(@RequestBody Student student) {
		System.out.println("STudent save works properly");
		serviceImpl.saveStudent(student);
		return student;
	}
	
	@GetMapping(value = "findAll")
	public List<Student> findAll(){
		return serviceImpl.findAllStudents();
		
	}
	
	@PostMapping(value = "updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		serviceImpl.updateStudent(student);
		return student;
		
	}
	
	@PostMapping(value = "deleteStudent")
	public Student deleteStudent(@RequestBody Student student) {
		serviceImpl.deleteStudent(student);
		return student;
	}
	
	
}
