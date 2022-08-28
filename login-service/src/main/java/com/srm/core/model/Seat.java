package com.srm.core.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "seat")
public class Seat {

	@Transient
	public static final String SEQUENCE_NAME = "Total_Seat";

	@Id
	private int seatId;

	private int rowno;

	public int getRowno() {
		return this.rowno;
	}

	public void setRowno(int rowno) {
		this.rowno = rowno;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	// @Indexed(unique = true)
	private String seatNo;
	
	private String userId;

	@Field("Department")
	private String dept;

	@Field("Location")
	private String location;

	@Field("City")
	private String city;

	@Field("Status")
	private String status;
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Field("Date")
	@DateTimeFormat(pattern = "DD/MM/YYYY")
	private String fromDate;

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public Seat(int seatId, int rowno, String seatNo, String userId, String dept, String location, String city,
			String status, String fromDate) {
		super();
		this.seatId = seatId;
		this.rowno = rowno;
		this.seatNo = seatNo;
		this.userId = userId;
		this.dept = dept;
		this.location = location;
		this.city = city;
		this.status = status;
		this.fromDate = fromDate;
	}

	

}
