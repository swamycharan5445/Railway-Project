package com.nit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PassengerData
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	private String name;
	private Integer age;
	private String gender;
	private String berthPref;
	
	
	
}
