package com.srm.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.srm.core.model.Seat;
import com.srm.core.repository.SeatRepository;

@Service
public class SeatService {
    @Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private SeqService seqService;
	
	//create
	public Seat create(Seat seat) {
		return seatRepository.save(seat);
	}
	
	public List<Seat> getAllSeat() {
		return seatRepository.findAll();	
	}
	public Optional<Seat>getById(String seatNo){
		return seatRepository.findById(seatNo);
	}
	
	public List<Seat> getAllSeatByDept(String dept) {	
		return seatRepository.findAllByDept(dept);
	}
	public List<Seat> getAllSeatByFromDate(String date) {	
		return seatRepository.findAllByFromDate(date);
	}
	
//	public List<Seat> getAllSeatByStaus(String status) {	
//		return seatRepository.findAllByStatus(status);
//	}
	
	public List<Seat> findAllByFromDate(String fromDate, String dept) {	
		System.out.println("service");
		
		List<Seat> s =seatRepository.getSeatByDeptandFromDateList(dept, fromDate);
		System.out.println("s  "+s);
		return s;
	}
}
