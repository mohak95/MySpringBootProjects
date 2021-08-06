package com.app.techworm.main.serviceimplemenattion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.techworm.main.dao.StudentRepository;
import com.app.techworm.main.model.Student;
import com.app.techworm.main.serviceinterface.StudentInterface;



@Service
public class StudentServiceImpl implements StudentInterface{

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Student saveStudent(Student student) {

		return studentRepo.save(student);
	}

	@Override
	public Student updateStudent(Student student) {

		return studentRepo.save(student);
	}

	@Override
	public List<Student> findAllStudents() {

		return (List<Student>) studentRepo.findAll();
	}

	@Override
	public void deleteStudent(Student student) {

		studentRepo.delete(student);
		
	}

	
	
}
