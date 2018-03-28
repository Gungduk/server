package com.hybrid.gungduk.dto;

public class RangeQuestDto {
	double latitude;
	double longitude;
	String id;
	public RangeQuestDto(double latitude, double longitude, String id) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.id = id;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
