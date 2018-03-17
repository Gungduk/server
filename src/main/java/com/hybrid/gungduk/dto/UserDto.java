package com.hybrid.gungduk.dto;

public class UserDto {
	String id;
	String pw;
	String phoneNum;
	
	public UserDto() {}
	
	public UserDto(String id, String pw, String phoneNum) {
		super();
		this.id = id;
		this.pw = pw;
		this.phoneNum = phoneNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
}
