package com.jdbctest.SpringJdbcApp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbctest.SpringJdbcApp.constants.UserConstant;
import com.jdbctest.SpringJdbcApp.pojo.UserStudent;
import com.jdbctest.SpringJdbcApp.query.QueryString;
import com.jdbctest.SpringJdbcApp.setter.UserStudentSetter;

@Repository
public class UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	
	Logger logger
    = Logger.getLogger(
    		UserRepository.class.getName());
	
	public List<String> getAllUsersName(UserConstant userConstant) {
		
		List<String> usernameList = new ArrayList<>();
		
		String query = QueryString.getQueryString(userConstant);
		
		usernameList.addAll(jdbcTemplate.queryForList(query, String.class));
		
		return usernameList;
	}


	@SuppressWarnings("unchecked")
	public List<?> getAllUserStudents(UserConstant constant, String pojo) throws ClassNotFoundException {
		// TODO Auto-generated method stub
           // List<Map<String, Object>> usernameList = new ArrayList<>();
		
		
		logger.info("Present ======="+pojo);
		
		String query = QueryString.getQueryString(constant);
		
		List<?> object = null;
		
		@SuppressWarnings("rawtypes")
		BeanPropertyRowMapper bean = new BeanPropertyRowMapper(Class.forName(pojo));
		
		object = jdbcTemplate.query(query, bean);
		
		return object;
	}


	@SuppressWarnings("unchecked")
	public List<?> getUserStudentById(UserConstant getStudentById,MapSqlParameterSource parameter, String pojo) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		String query = QueryString.getQueryString(getStudentById);
		
		BeanPropertyRowMapper bean = new BeanPropertyRowMapper(Class.forName(pojo));
		
		List<?> object = null;
		
		object =   namedParameterJdbcTemplate.query(query,parameter,bean);
		
		return object;
	}


	public void doBatchInsert(UserConstant insertStudentDetails, List<UserStudent> studentList) {
		// TODO Auto-generated method stub
		
		String query = QueryString.getQueryString(insertStudentDetails);
		
		BatchPreparedStatementSetter setter = new UserStudentSetter(studentList);
		
		int[] i = jdbcTemplate.batchUpdate(query, setter);
		
		System.out.println(i.length);
	}

}
