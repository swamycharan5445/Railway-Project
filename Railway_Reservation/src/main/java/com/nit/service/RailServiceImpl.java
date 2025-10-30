package com.nit.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.nit.model.BookingData;
import com.nit.model.PassengerData;
import com.nit.model.RailwayData;
import com.nit.model.TrainData;
import com.nit.repository.BookingRepository;
import com.nit.repository.PassengerRepository;
import com.nit.repository.RailRepository;
import com.nit.repository.TrainRepository;

@Service
public class RailServiceImpl implements RailService {

    @Autowired
    private RailRepository railRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public String registerUser(RailwayData railwayData, String password, String confirmPassword) {
        if (!railwayData.getPassword().equals(password)) {
            railwayData.setPassword(password);
        }
        if (password != null && password.equals(confirmPassword)) {
            railRepository.save(railwayData);
            return "success";
        }
        return "fail";
    }

    @Override
    public RailwayData loginUser(String username, String password) {
        return railRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public RailwayData findUserByUsername(String username) {
        return railRepository.findByUsername(username);
    }

    @Override
    public String resetPassword(String username, String newPassword, String confirmPassword) {
        RailwayData user = railRepository.findByUsername(username);
        if (user != null && newPassword.equals(confirmPassword)) {
            user.setPassword(newPassword);
            railRepository.save(user);
            return "success";
        }
        return "fail";
    }

    @Override
    public List<TrainData> getTrainList(String fromStation, String toStation) {
        return trainRepository.findByFromStationAndToStation(fromStation, toStation);
    }

    @Override
    public TrainData getTrainById(Integer trainId) {
        return trainRepository.findById(trainId).orElse(null);
    }

    @Override
    public BookingData createBooking(RailwayData user, TrainData train, String fromStation, String toStation,
                                     LocalDate dateOfJourney, String seatClass, String quota) {
        BookingData booking = new BookingData();
        booking.setUser(user);
        booking.setTrain(train);
        booking.setFromStation(fromStation);
        booking.setToStation(toStation);
        booking.setDateOfJourney(dateOfJourney);
        booking.setSeatClass(seatClass);
        booking.setQuota(quota);
        return bookingRepository.save(booking);
    }

    @Override
    public PassengerData addPassengerToBooking(BookingData booking, PassengerData passenger) {
        passenger.setBooking(booking);
        return passengerRepository.save(passenger);
    }

    @Override
    public String generateTicket(BookingData booking, PassengerData passenger, Model model) {
        TrainData train = booking.getTrain();
        Double price = calculatePrice(train, booking.getSeatClass());
        Double cfee = 15.00;
        Double insurance = 1.20;
        Double total = price + cfee + insurance;
        String transactionId = "TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        model.addAttribute("dateOfJourney", booking.getDateOfJourney());
        model.addAttribute("fromStation", booking.getFromStation());
        model.addAttribute("toStation", booking.getToStation());
        model.addAttribute("departure", train.getDepartureTime());
        model.addAttribute("arrival", train.getArrivalTime());
        model.addAttribute("trainNo", train.getTrainNumber());
        model.addAttribute("trainName", train.getTrainName());
        model.addAttribute("ticketClass", booking.getSeatClass());
        model.addAttribute("quota", booking.getQuota());
        model.addAttribute("timeOfJourney", train.getDuration());
        model.addAttribute("passenger", passenger);
        model.addAttribute("transactionId", transactionId);
        model.addAttribute("price", price);
        model.addAttribute("convenienceFee", cfee);
        model.addAttribute("insurance", insurance);
        model.addAttribute("totalFare", total);

        return "FinalTicket";
    }

    private Double calculatePrice(TrainData train, String seatclass) {
        return switch (seatclass) {
            case "Sleeper" -> train.getSleeper();
            case "First AC" -> train.getFirstAC();
            case "Second AC" -> train.getSecondAC();
            case "Third AC" -> train.getThirdAC();
            default -> 0.0;
        };
    }

    @Override
    public List<BookingData> getBookingsByUser(String username) {
        return bookingRepository.findByUserUsername(username);
    }
}
