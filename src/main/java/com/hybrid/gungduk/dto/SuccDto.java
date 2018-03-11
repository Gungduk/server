package com.hybrid.gungduk.dto;

public class SuccDto {
	String email;
	String qstName;
	String yesOrNo;
	
	public SuccDto(String email, String qstName) {
		super();
		this.email = email;
		this.qstName = qstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQstName() {
		return qstName;
	}
	public void setQstName(String qstName) {
		this.qstName = qstName;
	}
	public String getYesOrNo() {
		return yesOrNo;
	}
	public void setYesOrNo(String yesOrNo) {
		this.yesOrNo = yesOrNo;
	}
}
