package com.srm.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.srm.core.model.Seat;

@Repository
public interface SeatRepository extends MongoRepository<Seat, String> {

	List<Seat> findAllByDept(String dept);

	// List<Seat> findAllByStatus(String status);

	@Query("{'SeatBooking.fromDate': ?0}")
	List<Seat> findAllByFromDate(String fromDate);

	@org.springframework.data.mongodb.repository.Query("{dept: ?0, fromDate: ?1}")
	List<Seat> getSeatByDeptandFromDateList(String dept, String date);

}
