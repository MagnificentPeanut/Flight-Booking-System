package com.capg.repository;

import com.capg.entity.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flights, Integer> {

}
