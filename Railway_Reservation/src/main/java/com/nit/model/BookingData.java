package com.nit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class BookingData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "From station is required")
    private String fromStation;

    @NotBlank(message = "To station is required")
    private String toStation;

    @NotNull(message = "Journey date is required")
    @Future(message = "Journey date must be in the future")
    private LocalDate dateOfJourney;

    @NotBlank(message = "Seat class is required")
    private String seatClass;

    @NotBlank(message = "Quota is required")
    private String quota;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private RailwayData user;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PassengerData> passengers;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private TrainData train;
}
