package com.hybrid.gungduk.dto;

public class SuccDto {
	String id;
	String qstName;
	String yesOrNo;
	
	public SuccDto(String id, String qstName) {
		super();
		this.id = id;
		this.qstName = qstName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
