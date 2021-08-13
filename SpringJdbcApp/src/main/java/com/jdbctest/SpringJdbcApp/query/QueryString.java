package com.jdbctest.SpringJdbcApp.query;

import com.jdbctest.SpringJdbcApp.constants.UserConstant;

public class QueryString {

	public static String getQueryString(UserConstant constant) {

		switch (constant) {
		case GET_USER_DETAILS:

			return "SELECT name FROM student_data";
		case GET_USERSTUDENT_DETAILS:

			return "SELECT id,address,name,roll FROM student_data";
		case GET_STUDENT_BY_ID:

			return "SELECT id,address,name,roll FROM student_data where id = :id";
		case INSERT_STUDENT_DETAILS:

			return "INSERT INTO `student_database`.`student_data` (`id`,`address`,`name`,`roll`) VALUES (?,?,?,?);";
		default:
			return null;
		}	
	}
}
