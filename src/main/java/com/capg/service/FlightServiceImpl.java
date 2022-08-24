package com.capg.service;

import com.capg.dto.FlightsDTO;
import com.capg.entity.Flights;
import com.capg.exception.FlightNotFoundException;
import com.capg.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public abstract class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository flightRepository;
    //Get all flight details
    @Override
    public List<FlightsDTO> getFlights() {
        List<Flights> flights = flightRepository.findAll();
        return flights.stream().map(FlightsDTO::new).collect(Collectors.toList());
    }
    //Find flight by ID
    @Override
    public FlightsDTO getFlight(Integer id) {
        Flights flights = flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight does not exist with id: " + id));
        return new FlightsDTO(flights);
    }
    //Create new flight
    @Override
    public FlightsDTO newFlight(FlightsDTO flightsDTO) {
        Flights flights = new Flights(flightsDTO);
        return new FlightsDTO(flightRepository.save(flights));
    }
    //Update flight
    @Override
    public FlightsDTO updateFlight(Integer id, FlightsDTO flightsDTO) {
        Flights flights = flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight does not exist with id: " + id));

        flights.setFlightName(flightsDTO.getFlightName());
        flights.setOrigin(flightsDTO.getOrigin());
        flights.setDestination(flightsDTO.getDestination());
        flights.setDepartureTime(flightsDTO.getDepartureTime());
        flights.setArrivalTime(flightsDTO.getArrivalTime());
        flights.setSeats(flightsDTO.getSeats());
        flights.setFare(flightsDTO.getFare());

        return new FlightsDTO(flights);
    }
    //Delete flight with given ID
    @Override
    public void deleteFlight(Integer id) {
        Flights flights = flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight does not exist with id: " + id));
        flightRepository.delete(flights);
    }
    //Delete all flights
    @Override
    public void deleteAll() {
        flightRepository.deleteAll();
    }
}
