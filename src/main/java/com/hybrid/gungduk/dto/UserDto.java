package com.hybrid.gungduk.dto;

public class UserDto {
	String id;
	String pw;
	String phoneNum;
	String email = null;
	int level = 1;
	
	public UserDto() {}
	
	public UserDto(String id, String pw, String phoneNum, String email, int level) {
		super();
		this.id = id;
		this.pw = pw;
		this.phoneNum = phoneNum;
		this.email = email;
		this.level = level;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
