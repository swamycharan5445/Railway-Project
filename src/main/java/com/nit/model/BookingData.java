package com.nit.model;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BookingData 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String fromStation;
	private String toStation;
	private LocalDate dateOfJourney;
	private String seatclass;
	private String quota;

}
