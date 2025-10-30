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
import jakarta.validation.Valid;

@Controller
public class RailController {

    @Autowired
    private RailService railService;

    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }
    

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("railwayData", new RailwayData());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute RailwayData railwayData,
                               @RequestParam String password,
                               @RequestParam String confirmpassword,
                               Model model) {
        String result = railService.registerUser(railwayData, password, confirmpassword);
        if ("success".equals(result)) {
            model.addAttribute("message", "Registration Successful! Please login.");
            return "login";
        } else {
            model.addAttribute("msg", "Password and Confirm Password must match!");
            return "registerFail";
        }
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password,
                            HttpServletRequest request,
                            Model model) {
        RailwayData user = railService.loginUser(username, password);
        if (user != null) {
            request.getSession().setAttribute("loggedInUser", user);
            model.addAttribute("success", "Login successful");
            return "booking";
        } else {
            model.addAttribute("error", "Invalid Username or Password");
            return "fail";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }

    @PostMapping("/searchTrains")
    public String searchTrains(@RequestParam String fromStation,
                               @RequestParam String toStation,
                               Model model) {
        List<TrainData> trains = railService.getTrainList(fromStation, toStation);
        model.addAttribute("trains", trains);
        return "trainList";
    }

    @PostMapping("/bookTicket")
    public String bookTicket(@RequestParam Integer trainId,
                             @RequestParam String fromStation,
                             @RequestParam String toStation,
                             @RequestParam String seatClass,
                             @RequestParam String quota,
                             @RequestParam String dateOfJourney,
                             HttpServletRequest request,
                             Model model) {

        RailwayData user = (RailwayData) request.getSession().getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }

        TrainData train = railService.getTrainById(trainId);

        BookingData booking = railService.createBooking(user, train, fromStation, toStation,
                                                        LocalDate.parse(dateOfJourney), seatClass, quota);

        request.getSession().setAttribute("currentBooking", booking);
        model.addAttribute("train", train);
        return "passengerDetails";
    }

    @PostMapping("/submitPassenger")
    public String submitPassenger(@Valid @ModelAttribute PassengerData passengerData,
                                  HttpServletRequest request,
                                  Model model) {
        BookingData booking = (BookingData) request.getSession().getAttribute("currentBooking");
        if (booking == null) {
            return "redirect:/booking";
        }
        PassengerData savedPassenger = railService.addPassengerToBooking(booking, passengerData);
        return railService.generateTicket(booking, savedPassenger, model);
    }

    @GetMapping("/myBookings")
    public String viewMyBookings(HttpServletRequest request, Model model) {
        RailwayData loggedInUser = (RailwayData) request.getSession().getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        List<BookingData> bookings = railService.getBookingsByUser(loggedInUser.getUsername());
        model.addAttribute("bookings", bookings);
        return "myBookings";
    }
}
