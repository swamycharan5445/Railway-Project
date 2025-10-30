package com.nit.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nit.model.*;
import com.nit.service.RailService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RailController 
{

    @Autowired
    private RailService railService;

    private List<BookingData> byDateOfJourney;
    private List<TrainData> byFromStationAndToStation;
    private List<BookingData> bySeatclass;
    private List<BookingData> byQuota;

    @GetMapping("/welcome")
    public String welcomePage(Model m) 
    {
        return "welcome";
    }

    @GetMapping("/login")
    public String loginPage(Model m) 
    {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model m) 
    {
        return "register";
    }

    @PostMapping("/register")
    public String registerPage2(@ModelAttribute RailwayData railwayData,
    		                    @RequestParam String email,
    		                    @RequestParam String phonenumber,
                                 @RequestParam String password,
                                 @RequestParam String confirmpassword,
                                 Model m) 
    {

        String result = railService.registerUser(railwayData, password, confirmpassword,email,phonenumber);
        System.err.println(result+"   result of controller");
        if ("success".equals(result)) 
        {
            m.addAttribute("message", railService.getAllUsers());
            return "login";
        } 
        else 
        {
            m.addAttribute("msg", "Password And ConfirmPassword must be Same");
            m.addAttribute("data", "email found in my database");
            return "register";
        }
    }

    @PostMapping("/login")
    public String loginPage2(@RequestParam String username,
                              @RequestParam String password,
                              Model m) 
    {
        String result = railService.loginUser(username, password);
        if ("success".equals(result)) 
        {
            m.addAttribute("success", "UserName And Password is Correct");
            return "booking";
        }
        else 
        {
            m.addAttribute("error", "Invalid Username or Password");
            return "fail";
        }
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordForm() 
    {
        return "forgotPassword";
    }

    @PostMapping("/forgot-password")
    public String resetPassword(@RequestParam String username,
                                @RequestParam String newPassword,
                                @RequestParam String confirmPassword,
                                Model m) 
    {
        String result = railService.resetPassword(username, newPassword, confirmPassword);
        return "success".equals(result) ? "login" : "fail";
    }

    @PostMapping("/bookTicket")
    public String bookingData(@RequestParam String fromStation,
                              @RequestParam String toStation,
                              @RequestParam String seatclass,
                              @RequestParam String quota,
                              @RequestParam LocalDate dateOfJourney,
                              @ModelAttribute BookingData bookingData,
                              Model m) 
    {

        railService.saveBooking(bookingData);

        byDateOfJourney = railService.getBookingsByDateSeatQuota(dateOfJourney, seatclass, quota);
        bySeatclass = railService.getBookingsBySeatclass(seatclass);
        byQuota = railService.getBookingsByQuota(quota);
        byFromStationAndToStation = railService.getTrainList(fromStation, toStation);

        m.addAttribute("trains", byFromStationAndToStation);
        m.addAttribute("booking", byDateOfJourney);
        return "trainList";
    }

    @PostMapping("/bookTrain")
    public String trainDetails(HttpServletRequest request, Model m) 
    {
        m.addAttribute("trainNumber", request.getParameter("selectedTrain"));
        return "passengerDetails";
    }

    @PostMapping("/submitPassengers")
    public String passengerData(@ModelAttribute PassengerData passengerData,
                                Model m,
                                HttpServletRequest request) 
    {

        return railService.processPassengerAndGenerateTicket(passengerData, bySeatclass, byQuota, byDateOfJourney, byFromStationAndToStation, request, m);
    }
}
