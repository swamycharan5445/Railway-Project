package com.nit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.model.TrainData;

public interface TrainRepository extends JpaRepository<TrainData, Integer>
{

	List<TrainData> findByFromStationAndToStation(String fromStation, String toStation);
	List<TrainData> findByArrivalTime(TrainData trainData);
	List<TrainData> findByDepartureTime(TrainData trainData);
	

}
