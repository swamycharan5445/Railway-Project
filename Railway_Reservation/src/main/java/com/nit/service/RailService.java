package com.nit.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.ui.Model;

import com.nit.model.*;

import jakarta.servlet.http.HttpServletRequest;

public interface RailService {

    // user
    String registerUser(RailwayData railwayData, String password, String confirmPassword);

    RailwayData loginUser(String username, String password);

    RailwayData findUserByUsername(String username);

    String resetPassword(String username, String newPassword, String confirmPassword);

    // trains & search
    List<TrainData> getTrainList(String fromStation, String toStation);

    TrainData getTrainById(Integer trainId);

    // booking flow
    BookingData createBooking(RailwayData user, TrainData train, String fromStation, String toStation,
                              LocalDate dateOfJourney, String seatClass, String quota);

    PassengerData addPassengerToBooking(BookingData booking, PassengerData passenger);

    String generateTicket(BookingData booking, PassengerData passenger, Model model);

    List<BookingData> getBookingsByUser(String username);
}
