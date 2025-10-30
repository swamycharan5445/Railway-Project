package com.nit.service;



import java.time.LocalDate;
import java.util.List;

import org.springframework.ui.Model;

import com.nit.model.*;

import jakarta.servlet.http.HttpServletRequest;

public interface RailService {

    String registerUser(RailwayData railwayData, String password, String confirmPassword,String email,String phonenumber);

    String loginUser(String username, String password);

    String resetPassword(String username, String newPassword, String confirmPassword);

    List<RailwayData> getAllUsers();

    List<TrainData> getTrainList(String fromStation, String toStation);

    List<BookingData> getBookingsByDateSeatQuota(LocalDate date, String seatclass, String quota);

    List<BookingData> getBookingsBySeatclass(String seatclass);

    List<BookingData> getBookingsByQuota(String quota);

    BookingData saveBooking(BookingData bookingData);

    PassengerData savePassenger(PassengerData passengerData);

    TrainData getTrainById(Integer trainNo);

    Double calculatePrice(TrainData train, String seatclass);

    String generateTransactionId();

    String processPassengerAndGenerateTicket(PassengerData passengerData,
                                             List<BookingData> bySeatclass,
                                             List<BookingData> byQuota,
                                             List<BookingData> byDateOfJourney,
                                             List<TrainData> byFromStationAndToStation,
                                             HttpServletRequest request,
                                             Model model);
}

