package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.model.BookingData;
import java.util.List;
import java.time.LocalDate;


public interface BookingRepository extends JpaRepository<BookingData, Integer>
{
	List<BookingData> findByDateOfJourney(LocalDate dateOfJourney);
	List<BookingData> findBySeatclass(String seatclass);
	List<BookingData> findByQuota(String quota);
}
