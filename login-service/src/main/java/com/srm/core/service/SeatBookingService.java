package com.srm.core.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srm.core.model.SeatBooking;
import com.srm.core.repository.SeatBookingRepository;

@Service
public class SeatBookingService {

	@Autowired
	private SeatBookingRepository seatBookingRepository;

	@Autowired
	private SeqService seqService;

	public SeatBooking create(SeatBooking seatBooking) {
		return seatBookingRepository.save(seatBooking);
	}

	public List<SeatBooking> getAllSeats() {
		return seatBookingRepository.findAll();
	}

	public Optional<SeatBooking> getBySeatNo(String seatNo) {
		return seatBookingRepository.findBookingBySeatNo(seatNo);
	}

	public List<SeatBooking> getByfromDate(String fromDate) {
		return seatBookingRepository.getAllByFromDate(fromDate);
	}

	public Optional<SeatBooking> getByBookingId(Integer bookingId) {
		return seatBookingRepository.findBookingByBookingId(bookingId);
	}

	public SeatBooking modify(SeatBooking seatBooking) {
		return seatBookingRepository.save(seatBooking);
	}

	public SeatBooking cancelbooking(Integer bookingId) {
		SeatBooking b = seatBookingRepository.findByBookingId(bookingId);
		b.setStatus("Cancel");
		return seatBookingRepository.save(b);
	}

	public List<SeatBooking> getRequest(String approver, String status) {
		return seatBookingRepository.getApprover(approver, status);
	}

	public List<SeatBooking> getUserRequest(String userid) {
		return seatBookingRepository.getAllByUserId(userid);
	}

	public List<SeatBooking> getUser(String userid, String status) {
		return seatBookingRepository.getAllByUserIdAndStatus(userid, status);
	}

	public List<SeatBooking> getAllDate(String fromDate, String toDate) {
		return seatBookingRepository.getAllDateBetweentwoDates(fromDate, toDate);
	}

	public List<SeatBooking> getAllByApprover(String approver) {
		return seatBookingRepository.getAllByApprover(approver);
	}

	public Optional<SeatBooking> getByApprover(String approver) {
		return seatBookingRepository.getByApprover(approver);
	}

	public Optional<SeatBooking> getByBooking(Integer bookingId) {
		return seatBookingRepository.findBookingBy(bookingId);
	}
}
