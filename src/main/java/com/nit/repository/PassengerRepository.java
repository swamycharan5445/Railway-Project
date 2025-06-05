package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.model.PassengerData;
import java.util.List;


public interface PassengerRepository extends JpaRepository<PassengerData, Integer>
{
	PassengerData findByName(String name);
}
