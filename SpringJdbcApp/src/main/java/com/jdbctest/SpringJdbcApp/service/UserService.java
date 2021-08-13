package com.jdbctest.SpringJdbcApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.jdbctest.SpringJdbcApp.constants.UserConstant;
import com.jdbctest.SpringJdbcApp.pojo.UserStudent;
import com.jdbctest.SpringJdbcApp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	

	
	public List<String> getAllUsers() {
		// TODO Auto-generated method stub
		
		
		
		List<String> usernameList = userRepository.getAllUsersName(UserConstant.GET_USER_DETAILS);

		return usernameList;
	}


	public List<?> getAllUserStudents() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
		
		 
		List<?> usernameList = userRepository.getAllUserStudents(UserConstant.GET_USERSTUDENT_DETAILS,"com.jdbctest.SpringJdbcApp.pojo.UserStudent");

		return usernameList;
	}


	public List<?> getUserStudentById(int id) throws ClassNotFoundException {
		
		MapSqlParameterSource parameter = new MapSqlParameterSource("id", id);
		
		return userRepository.getUserStudentById(UserConstant.GET_STUDENT_BY_ID,parameter,"com.jdbctest.SpringJdbcApp.pojo.UserStudent");
		
		
	}


	public void saveStudents(List<UserStudent> studentList) {
		
		userRepository.doBatchInsert(UserConstant.INSERT_STUDENT_DETAILS, studentList);
		
		
	}

}
