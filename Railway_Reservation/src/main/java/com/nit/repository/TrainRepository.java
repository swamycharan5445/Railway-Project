package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.model.TrainData;

@Repository
public interface TrainRepository extends JpaRepository<TrainData, Integer> {

    List<TrainData> findByFromStationAndToStation(String fromStation, String toStation);

    List<TrainData> findByTrainNameContainingIgnoreCase(String trainName);
}
