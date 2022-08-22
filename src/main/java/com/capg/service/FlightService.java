package com.capg.service;

import com.capg.dto.FlightsDTO;

import java.util.List;

public interface FlightService {

    List<FlightsDTO> getFlights();
    FlightsDTO getFlight(Integer id);
    FlightsDTO newFlight(FlightsDTO flightsDTO);
    FlightsDTO updateFlight(Integer id, FlightsDTO flightsDTO);
    void deleteFlight(Integer id);
    void deleteAll();

}
