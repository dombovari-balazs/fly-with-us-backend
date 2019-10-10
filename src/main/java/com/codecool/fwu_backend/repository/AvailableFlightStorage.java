package com.codecool.fwu_backend.repository;

import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.model.Movie;
import com.codecool.fwu_backend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



public interface AvailableFlightStorage extends JpaRepository<Flight, Long> {
    List<Flight> getFlightsByCityFromAndCityToAndDate(String cityFrom, String cityTo, String date);


    List<Seat> getAllAvailableSeatByFlightId();
}
