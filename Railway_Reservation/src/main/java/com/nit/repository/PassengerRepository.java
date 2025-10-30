package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.model.PassengerData;
import com.nit.model.BookingData;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerData, Integer> {

    List<PassengerData> findByBooking(BookingData booking);

    List<PassengerData> findByBookingId(Integer bookingId);
}
