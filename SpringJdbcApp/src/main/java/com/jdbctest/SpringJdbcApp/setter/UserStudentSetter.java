package com.jdbctest.SpringJdbcApp.setter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.jdbctest.SpringJdbcApp.pojo.UserStudent;

public class UserStudentSetter implements BatchPreparedStatementSetter{

	
	private List<UserStudent> studentList;
	
	public UserStudentSetter(List<UserStudent> studentList){
		this.studentList =  studentList;
	}
	
	
	
	@Override
	public void setValues(PreparedStatement ps, int i) throws SQLException {
		// TODO Auto-generated method stub
		
		ps.setInt(1, studentList.get(i).getId());
		ps.setString(2, studentList.get(i).getAddress());
		ps.setString(3, studentList.get(i).getName());
		ps.setInt(4, studentList.get(i).getRoll());
		
	}

	@Override
	public int getBatchSize() {
		// TODO Auto-generated method stub
		return studentList.size();
	}

}
