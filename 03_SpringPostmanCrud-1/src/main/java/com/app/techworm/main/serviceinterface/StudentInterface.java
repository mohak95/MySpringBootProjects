package com.app.techworm.main.serviceinterface;

import java.util.List;

import com.app.techworm.main.model.Student;

public interface StudentInterface {

	//to save new Student
	public Student saveStudent(Student student);
	
	//to update student
	public Student updateStudent(Student student);
	
	//to fetch all student details
	public List<Student> findAllStudents();
	
	//to delete student
	public void deleteStudent(Student student);
	
	
}
