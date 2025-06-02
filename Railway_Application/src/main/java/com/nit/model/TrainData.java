package com.nit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainData 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer trainNumber;
    private String trainName;

    private String departureTime;  
    private String arrivalTime;     
    private String duration;       
    
    private String fromStation;    
    private String toStation; 
    
    private Double sleeper;
    private Double thirdAC;
    private Double secondAC;
    private Double firstAC;
}
