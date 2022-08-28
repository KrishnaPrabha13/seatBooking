package com.srm.core.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.srm.core.model.SeatBooking;

@Repository
public interface SeatBookingRepository extends MongoRepository<SeatBooking, String> {

	public Optional<SeatBooking> findBookingBySeatNo(String seatNo);

	public SeatBooking findBySeatNo(String seatNo);

	@Query()
	public SeatBooking findByBookingId(Integer bookingId);

	@org.springframework.data.mongodb.repository.Query("{status: ?1, approver: ?0}")
	public List<SeatBooking> getApprover(String approver, String status);

	public List<SeatBooking> getAllByApprover(String approver);

	public Optional<SeatBooking> getByApprover(String approver);

	public Optional<SeatBooking> findBookingBy(Integer bookingId);

	public Optional<SeatBooking> findBookingByBookingId(Integer bookingId);

	public List<SeatBooking> getAllByFromDate(String fromDate);

	public List<SeatBooking> getAllByUserId(String userid);

	// public List<SeatBooking> getAllByUserIdAndStatus(String userid, String
	// status);

	@org.springframework.data.mongodb.repository.Query("{userId: ?0, status: ?1}")
	List<SeatBooking> getAllByUserIdAndStatus(String userId, String status);

	@org.springframework.data.mongodb.repository.Query("{createdat:{$gt:?0, $lt:?1}}")
	List<SeatBooking> getAllDateBetweentwoDates(String fromDate, String ToDate);
}
