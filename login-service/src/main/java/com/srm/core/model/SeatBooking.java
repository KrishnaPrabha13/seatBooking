package com.srm.core.model;

import java.util.Date;

import javax.validation.constraints.Max;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "SeatBooking")
public class SeatBooking {

	@Transient
	public static final String SEQUENCE_NAME = "Total_Booking";

	@Id
	private Integer bookingId;

	// @Indexed(unique = true)

	private String seatNo;

	@Field(name = "userid")
	private String userId;

	@Field(name = "approver")
	private String approver;

	@Field(name = "status")
	private String status;

	@Field(name = "comment")
	private String comment;

	@Field(name = "reason")
	private String reason;

	@Field(name = "fromdate")
	private String fromDate;

	@Field(name = "todate")
	private String toDate;

	@Field(name = "createdat")
	private Date createDate;

	@Field(name = "updatedat")
	private Date modifiedDate;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public SeatBooking(Integer bookingId, String seatNo, String userId, String approver, String status, String comment,
			String reason, String fromDate, String toDate, Date createDate, Date modifiedDate) {
		this.bookingId = bookingId;
		this.seatNo = seatNo;
		this.userId = userId;
		this.approver = approver;
		this.status = status;
		this.comment = comment;
		this.reason = reason;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
	}

}
