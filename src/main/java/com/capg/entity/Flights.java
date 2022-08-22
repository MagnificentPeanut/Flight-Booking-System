package com.capg.entity;

import com.capg.dto.FlightsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flight_table")
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer flightId;
    @Column(name = "flight_name")
    private String flightName;
    @Column(name = "origin")
    private String origin;
    @Column(name = "destination")
    private String destination;
    @Column(name = "departure_time")
    private String departureTime;
    @Column(name = "arrival_time")
    private String arrivalTime;
    @Column(name = "seats")
    private Integer seats;
    @Column(name = "fare")
    private Integer fare;

    public Flights(FlightsDTO flightsDTO){
        this.flightId = flightsDTO.getFlightId();
        this.flightName = flightsDTO.getFlightName();
        this.origin = flightsDTO.getOrigin();
        this.destination = flightsDTO.getDestination();
        this.departureTime = flightsDTO.getDepartureTime();
        this.arrivalTime = flightsDTO.getArrivalTime();
        this.seats = flightsDTO.getSeats();
        this.fare = flightsDTO.getFare();
    }
}
