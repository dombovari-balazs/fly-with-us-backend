package com.codecool.fwu_backend.controller;

import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.repository.AvailableFlightStorage;
import com.codecool.fwu_backend.repository.BookedFlightStorage;
import com.codecool.fwu_backend.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/flights")
public class FlightsController {

    private AvailableFlightStorage flightStorage;
    private BookedFlightStorage bookedFlightStorage;
    private FlightService flightService;

    public FlightsController(AvailableFlightStorage flightStorage, BookedFlightStorage bookedFlightStorage, FlightService flightService) {
        this.flightStorage = flightStorage;
        this.bookedFlightStorage = bookedFlightStorage;
        this.flightService = flightService;
    }


    @GetMapping("/list")
    public void testInput(@RequestParam Map<String,String> parameters) {
        log.info(parameters.get("A"));
        log.info(parameters.get("B"));
    }


    @GetMapping("toroldkipls")
    public List<Flight> listFlights() {
        return flightStorage.findAll();

    }


    @GetMapping("toroldkiplseztis")
    public List<Flight> getFlights(@RequestParam String from, @RequestParam String to, @RequestParam String when) {
        flightService.addRandomAmountOfFlight(to, from, when);
        return flightStorage.getFlightsByCityFromAndCityToAndDate(from, to, when);
    }


    @GetMapping("list/bookings")
    public List<Flight> listBookedFlights() {
        return bookedFlightStorage.findAll();
    }

    @PostMapping("book")
    public void bookFlight(@RequestBody Flight flight) {
        bookedFlightStorage.save(flight);
    }

    @PutMapping("book")
    public void changeBookedFlight(@RequestBody Flight flight) {
        bookedFlightStorage.findById(flight.getId());
    }

    @DeleteMapping("book")
    public void deleteBookedFlight(@RequestBody Flight flight) {
        Flight booked = bookedFlightStorage.findById(flight.getId()).get();
        bookedFlightStorage.delete(booked);
    }
}
