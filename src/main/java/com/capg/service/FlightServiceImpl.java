package com.capg.service;

import com.capg.dto.FlightsDTO;
import com.capg.entity.Flights;
import com.capg.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository flightRepository;

    //Get all flight details
    @Override
    public List<FlightsDTO> getFlights() {
        List<Flights> flights = flightRepository.findAll();
        return flights.stream().map(FlightsDTO::new).collect(Collectors.toList());
    }

    @Override
    public FlightsDTO getFlight(Integer id) {
        return null;
    }

    @Override
    public FlightsDTO newFlight(FlightsDTO flightsDTO) {
        return null;
    }

    @Override
    public FlightsDTO updateFlight(Integer id, FlightsDTO flightsDTO) {
        return null;
    }

    @Override
    public void deleteFlight(Integer id) {

    }

    @Override
    public void deleteAll() {

    }
}
