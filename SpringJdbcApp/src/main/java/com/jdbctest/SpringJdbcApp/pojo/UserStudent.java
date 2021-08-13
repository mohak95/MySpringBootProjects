package com.jdbctest.SpringJdbcApp.pojo;

public class UserStudent {

	private int id;
	private String address;
	private String name;
	private int roll;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public UserStudent(int id, String address, String name, int roll) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.roll = roll;
	}
	@Override
	public String toString() {
		return "UserStudent [id=" + id + ", address=" + address + ", name=" + name + ", roll=" + roll + "]";
	}
	public UserStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
