package com.nit.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.model.BookingData;
import com.nit.model.PassengerData;
import com.nit.model.RailwayData;
import com.nit.model.TrainData;
import com.nit.repository.BookingRepository;
import com.nit.repository.PassengerRepository;
import com.nit.repository.RailRepository;
import com.nit.repository.TrainRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RailController 
{
	@Autowired
	private RailRepository railRepository;
	
	@Autowired 
	private BookingRepository bookingRepository; 
	
	@Autowired
	private TrainRepository trainRepository;
	
	@Autowired
    private PassengerRepository passengerRepository; 
	
	List<BookingData> byDateOfJourney;
	List<TrainData> byFromStationAndToStation;
	List<BookingData> bySeatclass;
	List<BookingData> byQuota;
	
	
	@GetMapping("/welcome")
	public String welcomePage(Model m)
	{
		m.addAttribute("welcome", m);
		return "welcome";	
	}
	
	
	@GetMapping("/login")
	public String  loginPage(Model m) 
	{
		m.addAttribute("login", m);
		return "login";
	}
	
	
	@GetMapping("/register")
	public String  registerPage(Model m) 
	{
		m.addAttribute("register", m);
		return "register";
	}
	
	@PostMapping("/register")
	public String registerPage2(@ModelAttribute RailwayData railwayData,Model m)
	{
		RailwayData save = railRepository.save(railwayData);
	    List<RailwayData> all = railRepository.findAll();
	    m.addAttribute("message", all);
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPage2(@RequestParam String username,
	                         @RequestParam String password,
	                         Model m) 
	{
	    RailwayData user = railRepository.findByUsernameAndPassword(username, password);
	    
	    if (user != null) 
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
			                    @ModelAttribute RailwayData railwayData,Model m)
	{
		RailwayData byUsername = railRepository.findByUsername(username);	
		
		if(byUsername!=null)
		{
			byUsername.setPassword(newPassword);
			byUsername.setConfirmpassword(confirmPassword);
			railRepository.save(byUsername);
			
			return "login";
		}
		else
		{
			return "fail";
		}
		
	}
	
	
	 
	@PostMapping("/bookTicket")
	public String bookingData(@RequestParam String fromStation,
		                      @RequestParam String toStation,
		                      @RequestParam String seatclass,
		                      @RequestParam String quota,
		                      @RequestParam LocalDate dateOfJourney,
		                      @ModelAttribute BookingData bookingData,Model m)
	{
		BookingData save = bookingRepository.save(bookingData);

		byDateOfJourney = bookingRepository.findByDateOfJourney(dateOfJourney);
		bySeatclass = bookingRepository.findBySeatclass(seatclass);
		byQuota = bookingRepository.findByQuota(quota);
		
		byFromStationAndToStation = trainRepository.findByFromStationAndToStation(fromStation, toStation);
		
		
		
	    m.addAttribute("trains", byFromStationAndToStation);
	    m.addAttribute("booking", byDateOfJourney);
	    return "trainList";
	}
	
	
	@PostMapping("/bookTrain")
	public String trainDetails(HttpServletRequest request,Model m)
	{

		m.addAttribute("trainNumber", request.getParameter("selectedTrain"));
		
		return "passengerDetails";
	}
	
	@PostMapping("/submitPassengers")
	public String passengerData(@ModelAttribute PassengerData passengerData 
			                    ,Model m,HttpServletRequest request)
	{
		
		passengerRepository.save(passengerData);
		TrainData byTrainNumber = trainRepository.findById(Integer.parseInt(request.getParameter("trainNo"))).get();
		System.err.println(byTrainNumber);
		
		System.err.println(bySeatclass.get(0).getSeatclass());
		System.err.println(byQuota.get(0).getQuota());
		
		Double price = switch (bySeatclass.get(0).getSeatclass()) 
					  {
		        	   case "Sleeper" ->	byTrainNumber.getSleeper();
		        	   case "First AC" -> byTrainNumber.getFirstAC();
		        	   case "Second AC" -> byTrainNumber.getSecondAC();
		        	   case "Third AC" ->byTrainNumber.getThirdAC();
		        	   default -> throw new IllegalArgumentException("Unexpected value");
		 };
		
		
		System.err.println(passengerData);
		String transactionId = "TXN" + System.currentTimeMillis();
		Double cfee=15.00;
		Double insurence=1.20;
		Double total=price+cfee+insurence;
		
		
		m.addAttribute("dateOfJourney",byDateOfJourney.get(0).getDateOfJourney());
		m.addAttribute("bookedfrom", byFromStationAndToStation.get(0).getFromStation());
		m.addAttribute("departure", byTrainNumber.getDepartureTime());
		m.addAttribute("arrival", byTrainNumber.getArrivalTime());
		m.addAttribute("toStation", byFromStationAndToStation.get(0).getToStation());
		m.addAttribute("trainNo", byTrainNumber.getTrainNumber());
		m.addAttribute("trainName", byTrainNumber.getTrainName());
		m.addAttribute("ticketClass", bySeatclass.get(0).getSeatclass());
		m.addAttribute("quota", byQuota.get(0).getQuota());
		m.addAttribute("timeOfJourney", byTrainNumber.getDuration());
		m.addAttribute("passengerList", passengerData);
		m.addAttribute("transactionId", transactionId);
		m.addAttribute("price", price);
		m.addAttribute("convenienceFee", cfee);
		m.addAttribute("insurance", insurence);
		m.addAttribute("totalFare", total);
	
		return "FinalTicket";
	}
		
}
