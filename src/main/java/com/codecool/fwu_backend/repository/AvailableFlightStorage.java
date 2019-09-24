package com.codecool.fwu_backend.repository;

import com.codecool.fwu_backend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface AvailableFlightStorage extends JpaRepository<Flight, Long> {
    public List<Flight> getFlightsByCityFromAndCityToAndDate(String cityFrom, String cityTo, String date);
}
