package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.model.BookingData;
import com.nit.model.RailwayData;

@Repository
public interface BookingRepository extends JpaRepository<BookingData, Integer> {

    List<BookingData> findByUser(RailwayData user);

    List<BookingData> findByUserUsername(String username);

    List<BookingData> findByFromStationAndToStation(String fromStation, String toStation);
}
