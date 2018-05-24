package com.hybrid.gungduk.dto;

public class QuestDto {
	int qstNum;
	String qstName;
	String plcName;
	double latitude;
	double longitude;
	String info;
	String qst;
	int answer;
	String qstEx1;
	String qstEx2;
	String qstEx3;
	String imgUrl;
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
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getQst() {
		return qst;
	}
	public void setQst(String qst) {
		this.qst = qst;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
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
	public String getQstEx3() {
		return qstEx3;
	}
	public void setQstEx3(String qstEx3) {
		this.qstEx3 = qstEx3;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return "{\"qstNum\":" + qstNum + ", \"qstName\": \"" + qstName + "\", \"plcName\": \"" + plcName + "\", \"latitude\":" + latitude
				+ ", \"longitude\":" + longitude + ", \"info\": \"" + info + "\", \"qst\":" + qst + "\", \"answer\":" + answer + ", \"qstEx1\": \""
				+ qstEx1 + "\", \"qstEx2\": \"" + qstEx2 + "\", \"qstEx3\": \"" + qstEx3 + "\", \"imgUrl\": \"" + imgUrl + "\" }";
	}

}