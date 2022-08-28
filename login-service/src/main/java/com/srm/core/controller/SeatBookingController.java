package com.srm.core.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.srm.core.exception.AlreadyExistException;
import com.srm.core.exception.ResourceNotFoundException;
import com.srm.core.model.RowList;
import com.srm.core.model.Seat;
import com.srm.core.model.SeatBooking;
import com.srm.core.service.SeatBookingService;
import com.srm.core.service.SeatService;
import com.srm.core.service.SeqService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class SeatBookingController {

	private static final String SEQUENCE_NAME = "total booking";

	@Autowired
	private SeatBookingService seatBookingService;

	@Autowired
	private SeqService seqService;

	@Autowired
	private SeatService seatService;

	@PostMapping("/booking/postbooking")
	public ResponseEntity<?> create(@RequestBody SeatBooking seatBooking) {
		seatBooking.setBookingId(seqService.getSqeNumber(SEQUENCE_NAME));
		Date createdate = new Date();
		seatBooking.setStatus("pending");
		seatBooking.setCreateDate(createdate);
		seatBookingService.create(seatBooking);
		return new ResponseEntity<>("Seat Booked and seat no is: " + seatBooking.getSeatNo(), HttpStatus.OK);
	}

	@GetMapping("/booking/getbookings")
	public ResponseEntity<?> getAllSeats(@RequestParam(required = false) String seatNo,
			@RequestParam(required = false) String fromDate) {
		List<RowList> rl = new ArrayList<RowList>();
		if (seatNo == null && fromDate == null) {
			List<SeatBooking> seatsBookings = seatBookingService.getAllSeats();
			return new ResponseEntity<List<SeatBooking>>(seatsBookings, HttpStatus.OK);
		} else if (seatNo != null && fromDate == null) {
			Optional<SeatBooking> seat = seatBookingService.getBySeatNo(seatNo);
			System.out.println(seat.isPresent());
			if (seat.isPresent()) {
				Optional<SeatBooking> seatBookings = seatBookingService.getBySeatNo(seatNo);
				System.out.println(seatBookings);
				return new ResponseEntity<Optional<SeatBooking>>(seatBookings, HttpStatus.OK);
			}
		} else if (fromDate != null && seatNo == null) {
			System.out.println("**************************");
			List<SeatBooking> seatBookings = seatBookingService.getByfromDate(fromDate);
			System.out.println(seatBookings);

			List<Seat> seatList = seatService.getAllSeat();
			int length = seatList.size() / 4;
			RowList[] rowList = new RowList[length + 1];
			System.out.println("seatlist" + seatList.get(1));
			int counter = 0;

			for (int i = 0; i < length; i++) {
				System.out.println("!!!!!!!!!!!!!1  ");
				List<Seat> seats = new ArrayList<Seat>();
				for (int j = 0; j < 4; j++) {
					System.out.println("@@@@@@@@@@@@@@!1  ");
					for (int k = 0; k < seatBookings.size(); k++) {
						System.out.println("###############  ");
						System.out.println("------  " + seatBookings.get(k));
						SeatBooking l = seatBookings.get(k);

						seatList.get(k);
						l.getSeatNo();
						l.getUserId();

						Seat sl = seatList.get(counter);

						System.out.println("&&&&&&" + counter);
						if (l.getSeatNo().equals(sl.getSeatNo())
								&& (l.getStatus().equals("pending") || (l.getStatus().equals("Approved")))) {
							sl.setStatus("Booked");
							sl.setUserId(l.getUserId());
							break;
						}

						// System.out.println()

					}

					seats.add(seatList.get(counter));
					counter++;
				}
				rowList[i] = new RowList("row " + i + 1, seats);
				rl.add(rowList[i]);
			}

			return new ResponseEntity<List<RowList>>(rl, HttpStatus.OK);

		}
		throw new ResourceNotFoundException("No Seat.No is found: " + seatNo);
	}

	@GetMapping("/booking/getseatbookings")
	public ResponseEntity<?> getAllSeatss(@RequestParam(required = false) String seatNo,
			@RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate)
			throws ParseException {
		List<RowList> rl = new ArrayList<RowList>();
		if (seatNo == null && fromDate == null) {
			List<SeatBooking> seatsBookings = seatBookingService.getAllSeats();
			return new ResponseEntity<List<SeatBooking>>(seatsBookings, HttpStatus.OK);
		} else if (seatNo != null && fromDate == null) {
			Optional<SeatBooking> seat = seatBookingService.getBySeatNo(seatNo);
			System.out.println(seat.isPresent());
			if (seat.isPresent()) {
				Optional<SeatBooking> seatBookings = seatBookingService.getBySeatNo(seatNo);
				System.out.println(seatBookings);
				return new ResponseEntity<Optional<SeatBooking>>(seatBookings, HttpStatus.OK);
			}
		} else if (fromDate != null && toDate != null) {
			// System.out.println(fromDate + toDate);
			// List<SeatBooking> request = seatBookingService.getAllDate(fromDate, toDate);

			// return new ResponseEntity<List<SeatBooking>>(request, HttpStatus.OK);

			String d1 = fromDate;
			String d2 = toDate;

			Date d_from = new SimpleDateFormat("yyy-MM-dd").parse(d1);
			Date d_end = new SimpleDateFormat("yyy-MM-dd").parse(d2);

			long t1 = d_from.getTime();
			long t2 = d_end.getTime();

			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

			if (t1 < t2) {

				System.out.println("**************************");
				for (long i = t1; i <= t2; i += 86400000) {

					System.out.println(f.format(i));

				}
			}

		} else if (fromDate != null && seatNo == null && toDate == null) {

			List<SeatBooking> seatBookings = seatBookingService.getByfromDate(fromDate);

			List<Seat> seatList = seatService.getAllSeat();
			int length = seatList.size() / 4;
			RowList[] rowList = new RowList[length + 1];
			System.out.println("seatlist" + seatList.get(1));
			int counter = 0;

			for (int i = 0; i < length; i++) {
				List<Seat> seats = new ArrayList<Seat>();
				for (int j = 0; j < 4; j++) {
					for (int k = 0; k < seatBookings.size(); k++) {
						System.out.println("------  " + seatBookings.get(k));
						SeatBooking l = seatBookings.get(k);

						seatList.get(k);
						l.getSeatNo();

						Seat sl = seatList.get(counter);
						System.out.println("0000" + l.getStatus());
						if (l.getSeatNo().equals(sl.getSeatNo())
								&& (l.getStatus().equals("pending") || (l.getStatus().equals("Approved")))) {
							sl.setStatus("Booked");
							sl.setFromDate(l.getFromDate());
							break;
						}

					}
					seats.add(seatList.get(counter));
					counter++;
				}
				rowList[i] = new RowList("row " + i + 1, seats);
				rl.add(rowList[i]);
			}

			return new ResponseEntity<List<RowList>>(rl, HttpStatus.OK);

		}
		throw new ResourceNotFoundException("No Seat.No is found: " + seatNo);
	}

	@GetMapping("/booking/getrequest")
	public ResponseEntity<?> getAllRequest(@RequestParam(required = false) String status,
			@RequestParam(required = false) String approver, @RequestParam(required = false) String userid) {

		// if (status == null && userid == null) {
		// List<SeatBooking> request = seatBookingService.getAllByApprover(approver);
		// return new ResponseEntity<List<SeatBooking>>(request, HttpStatus.OK);
		// }
		if (approver != null) {
			List<SeatBooking> request = seatBookingService.getRequest(approver, status);
			return new ResponseEntity<List<SeatBooking>>(request, HttpStatus.OK);
		} else if (userid != null && status == null && approver == null) {
			List<SeatBooking> request = seatBookingService.getUserRequest(userid);
			return new ResponseEntity<List<SeatBooking>>(request, HttpStatus.OK);
		} else if (approver == null) {
			List<SeatBooking> request = seatBookingService.getUser(userid, status);

			return new ResponseEntity<List<SeatBooking>>(request, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("No Approver found with name: " + approver);
	}

	@PutMapping("/booking/modifybooking")
	public ResponseEntity<?> modify(@RequestBody SeatBooking seatBooking,
			@RequestParam(required = false) Integer bookingId) {
		Optional<SeatBooking> seat = seatBookingService.getByBookingId(bookingId);
		if (seat.isPresent()) {
			SeatBooking s = seat.get();
			s.setSeatNo(seatBooking.getSeatNo() != null ? seatBooking.getSeatNo() : s.getSeatNo());
			s.setCreateDate(seatBooking.getCreateDate() != null ? seatBooking.getCreateDate() : s.getCreateDate());
			s.setApprover(seatBooking.getApprover() != null ? seatBooking.getApprover() : s.getApprover());
			s.setUserId(seatBooking.getUserId() != null ? seatBooking.getUserId() : s.getUserId());
			s.setStatus(seatBooking.getStatus() != null ? seatBooking.getStatus() : s.getStatus());
			s.setReason(seatBooking.getReason() != null ? seatBooking.getReason() : s.getReason());
			s.setModifiedDate(new Date());
			System.out.println(s);
			seatBookingService.modify(s);
			System.out.println(seatBooking);
			return new ResponseEntity<>("Booking modified with booking id: " + bookingId, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("BookingId" + " " + bookingId + " " + "is Not Found");
	}

	@DeleteMapping("/booking/cancelbooking")
	public ResponseEntity<?> cancel(@RequestParam Integer bookingId) {
		try {
			seatBookingService.cancelbooking(bookingId);
			return new ResponseEntity<>("Booking Cancel", HttpStatus.OK);
		} catch (Exception e) {
			throw new ResourceNotFoundException("No bookingid found");
		}
	}
}
