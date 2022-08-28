package com.srm.core.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import com.srm.core.model.RowList;
import com.srm.core.model.Seat;
import com.srm.core.service.SeatService;
import com.srm.core.service.SeqService;
import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class SeatController {
	private static final String SEQUENCE_NAME = "total seat";

	@Autowired
	private SeatService seatService;

	@Autowired
	private SeqService seqService;

	@PostMapping("/seats/postseat")
	public ResponseEntity<?> create(@RequestBody Seat seat) {
		try {
			seat.setSeatId(seqService.getSqeNumber(SEQUENCE_NAME));
			seatService.create(seat);
			return new ResponseEntity<>("Seat created", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/seats/getseat")
	public ResponseEntity<?> getAllBookings(@RequestParam(required = false) String seatNo,
			@RequestParam(required = false) String dept, @RequestParam(required = false) String fromDate) {
		if (dept == null & fromDate == null) {
			List<Seat> seats = seatService.getAllSeat();
			System.out.println("All Seat");
			return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);
		} else if (dept != null & fromDate == null) {
			List<Seat> seats = seatService.getAllSeatByDept(dept);
			System.out.println(dept);
			return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);
		} else if (fromDate != null & dept != null) {
			List<Seat> seats = seatService.findAllByFromDate(fromDate, dept);
			System.out.println(dept + " " + fromDate);
			System.out.println(seats);
			return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);
		}
		List<Seat> seats = seatService.getAllSeatByFromDate(fromDate);
		System.out.println(fromDate);
		return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);

	}

	@GetMapping("/seats/getseats")
	public List<RowList> getAllBooking(@RequestParam(required = false) String seatNo,
			@RequestParam(required = false) String dept, @RequestParam(required = false) String fromDate) {

		List<RowList> rl = new ArrayList<RowList>();
		List<Seat> seatList = seatService.getAllSeat();
		int length = seatList.size() / 4;
		RowList[] rowList = new RowList[length];
		System.out.println("seatlist" + seatList.get(1));
		int counter = 0;
		for (int i = 0; i < length; i++) {
			List<Seat> seats = new ArrayList<Seat>();
			for (int j = 0; j < 4; j++) {
				seats.add(seatList.get(counter));
				counter++;
			}
			rowList[i] = new RowList("row " + i + 1, seats);
			rl.add(rowList[i]);
		}
		System.out.println(getDatesBetweenUsingJava7(new Date(), new Date()));
		return rl;
	}

	private static Calendar getCalendarWithoutTime(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

	public static List getDatesBetweenUsingJava7(Date startDate, Date endDate) {
		System.out.println(startDate);
		System.out.println(endDate);
		List datesInRange = new ArrayList<>();
		Calendar calendar = getCalendarWithoutTime(startDate);
		Calendar endCalendar = getCalendarWithoutTime(endDate);

		while (calendar.before(endCalendar)) {
			Date result = calendar.getTime();
			datesInRange.add(result);
			calendar.add(Calendar.DATE, 1);
		}

		return datesInRange;
	}

}
