package com.hybrid.gungduk.dto;

import java.sql.Clob;

public class QuestDto {
	int qstNum;
	String qstName;
	String plcName;
	double latitude;
	double logitude;
	Clob info;
	Clob qst;
	String answer;
	String qstEx1;
	String qstEx2;
	String ImgUrl;
	
	public QuestDto(int qstNum, String qstName, String plcName, double latitude, double logitude, Clob info, Clob qst,
			String answer, String qstEx1, String qstEx2, String imgUrl) {
		super();
		this.qstNum = qstNum;
		this.qstName = qstName;
		this.plcName = plcName;
		this.latitude = latitude;
		this.logitude = logitude;
		this.info = info;
		this.qst = qst;
		this.answer = answer;
		this.qstEx1 = qstEx1;
		this.qstEx2 = qstEx2;
		ImgUrl = imgUrl;
	}

	public int getQstNum() {
		return qstNum;
	}

	public void setQstNum(int qstNum) {
		this.qstNum = qstNum;
	}

	public String getQstName() {
		return qstName;
	}

	public void setQstName(String qstName) {
		this.qstName = qstName;
	}

	public String getPlcName() {
		return plcName;
	}

	public void setPlcName(String plcName) {
		this.plcName = plcName;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLogitude() {
		return logitude;
	}

	public void setLogitude(double logitude) {
		this.logitude = logitude;
	}

	public Clob getInfo() {
		return info;
	}

	public void setInfo(Clob info) {
		this.info = info;
	}

	public Clob getQst() {
		return qst;
	}

	public void setQst(Clob qst) {
		this.qst = qst;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQstEx1() {
		return qstEx1;
	}

	public void setQstEx1(String qstEx1) {
		this.qstEx1 = qstEx1;
	}

	public String getQstEx2() {
		return qstEx2;
	}

	public void setQstEx2(String qstEx2) {
		this.qstEx2 = qstEx2;
	}

	public String getImgUrl() {
		return ImgUrl;
	}

	public void setImgUrl(String imgUrl) {
		ImgUrl = imgUrl;
	}
	
	
}