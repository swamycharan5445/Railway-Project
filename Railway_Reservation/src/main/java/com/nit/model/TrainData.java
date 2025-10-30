package com.nit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "train")
public class TrainData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Train number is required")
    @Column(unique = true, nullable = false)
    private Integer trainNumber;

    @NotBlank(message = "Train name is required")
    private String trainName;

    @NotBlank(message = "Departure time is required")
    private String departureTime;

    @NotBlank(message = "Arrival time is required")
    private String arrivalTime;

    @NotBlank(message = "Duration is required")
    private String duration;

    @NotBlank(message = "From station is required")
    private String fromStation;

    @NotBlank(message = "To station is required")
    private String toStation;

    @NotNull(message = "Sleeper price required")
    private Double sleeper;

    @NotNull(message = "3rd AC price required")
    private Double thirdAC;

    @NotNull(message = "2nd AC price required")
    private Double secondAC;

    @NotNull(message = "1st AC price required")
    private Double firstAC;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookingData> bookings;
}
