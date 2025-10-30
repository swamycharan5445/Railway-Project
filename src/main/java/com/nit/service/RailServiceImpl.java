package com.nit.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.nit.model.*;
import com.nit.repository.*;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class RailServiceImpl implements RailService 
{

    @Autowired
    private RailRepository railRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public String registerUser(RailwayData railwayData, String password, String confirmPassword,String email,String phonenumber) 
    {
    	System.err.println("------------------------------");
    	System.err.println(password);
    	System.err.println(confirmPassword);
    	System.err.println(email);
    	System.err.println(phonenumber);
    	
    	List<RailwayData> byEmail = railRepository.findByEmail(email);
    	System.err.println(byEmail.get(0).getEmail()+"---------------------");
    	List<RailwayData> byPhonenumber = railRepository.findByPhonenumber(phonenumber);
    	System.err.println(byPhonenumber.get(0).getPhonenumber()+"-------------------");
    	
    	
    	if(email==byEmail.get(0).getEmail())
    	{
    		System.err.println("success");
    		if (password.equals(confirmPassword)) 
            {
                railRepository.save(railwayData);
                return "success";
            }
            return "fail";
    	}
    	return "Datapresent";
        
    }

    @Override
    public String loginUser(String username, String password) 
    {
        RailwayData user = railRepository.findByUsernameAndPassword(username, password);
        return user != null ? "success" : "fail";
    }

    @Override
    public String resetPassword(String username, String newPassword, String confirmPassword) 
    {
        RailwayData user = railRepository.findByUsername(username);
        if (user != null && newPassword.equals(confirmPassword)) 
        {
            user.setPassword(newPassword);
            user.setConfirmpassword(confirmPassword);
            railRepository.save(user);
            return "success";
        }
        return "fail";
    }

    @Override
    public List<RailwayData> getAllUsers() 
    {
        return railRepository.findAll();
    }

    @Override
    public List<TrainData> getTrainList(String fromStation, String toStation) 
    {
        return trainRepository.findByFromStationAndToStation(fromStation, toStation);
    }

    @Override
    public List<BookingData> getBookingsByDateSeatQuota(LocalDate date, String seatclass, String quota)
    {
        return bookingRepository.findByDateOfJourney(date);
    }

    @Override
    public List<BookingData> getBookingsBySeatclass(String seatclass) 
    {
        return bookingRepository.findBySeatclass(seatclass);
    }

    @Override
    public List<BookingData> getBookingsByQuota(String quota)
    {
        return bookingRepository.findByQuota(quota);
    }

    @Override
    public BookingData saveBooking(BookingData bookingData) 
    {
        return bookingRepository.save(bookingData);
    }

    @Override
    public PassengerData savePassenger(PassengerData passengerData)
    {
        return passengerRepository.save(passengerData);
    }

    @Override
    public TrainData getTrainById(Integer trainNo) 
    {
        return trainRepository.findById(trainNo).orElse(null);
    }

    @Override
    public Double calculatePrice(TrainData train, String seatclass) 
    {
        return switch (seatclass) {
            case "Sleeper" -> train.getSleeper();
            case "First AC" -> train.getFirstAC();
            case "Second AC" -> train.getSecondAC();
            case "Third AC" -> train.getThirdAC();
            default -> throw new IllegalArgumentException("Invalid seat class");
        };
    }

    @Override
    public String generateTransactionId() 
    {
        return "TXN" + System.currentTimeMillis();
    }

    @Override
    public String processPassengerAndGenerateTicket(PassengerData passengerData,
                                                    List<BookingData> bySeatclass,
                                                    List<BookingData> byQuota,
                                                    List<BookingData> byDateOfJourney,
                                                    List<TrainData> byFromStationAndToStation,
                                                    HttpServletRequest request,
                                                    Model model) 
    {
        savePassenger(passengerData);

        Integer trainNo = Integer.parseInt(request.getParameter("trainNo"));
        TrainData train = getTrainById(trainNo);

        String seatClass = bySeatclass.get(0).getSeatclass();
        String quota = byQuota.get(0).getQuota();
        
        Double price = calculatePrice(train, seatClass);
        String transactionId = generateTransactionId();

        Double cfee = 15.00;
        Double insurance = 1.20;
        Double total = price + cfee + insurance;

        model.addAttribute("dateOfJourney", byDateOfJourney.get(0).getDateOfJourney());
        model.addAttribute("bookedfrom", byFromStationAndToStation.get(0).getFromStation());
        model.addAttribute("departure", train.getDepartureTime());
        model.addAttribute("arrival", train.getArrivalTime());
        model.addAttribute("toStation", byFromStationAndToStation.get(0).getToStation());
        model.addAttribute("trainNo", train.getTrainNumber());
        model.addAttribute("trainName", train.getTrainName());
        model.addAttribute("ticketClass", seatClass);
        model.addAttribute("quota", quota);
        model.addAttribute("timeOfJourney", train.getDuration());
        model.addAttribute("passengerList", passengerData);
        model.addAttribute("transactionId", transactionId);
        model.addAttribute("price", price);
        model.addAttribute("convenienceFee", cfee);
        model.addAttribute("insurance", insurance);
        model.addAttribute("totalFare", total);

        return "FinalTicket";
    }
}
