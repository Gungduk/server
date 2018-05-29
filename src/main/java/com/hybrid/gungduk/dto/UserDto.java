package com.hybrid.gungduk.dto;

public class UserDto {
	String id;
	String pw;
	String phoneNum;
	String email = null;
	
	public UserDto() {}
	
	public UserDto(String id, String pw, String phoneNum, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.phoneNum = phoneNum;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
