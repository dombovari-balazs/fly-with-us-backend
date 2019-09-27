package com.codecool.fwu_backend.controller;

import com.codecool.fwu_backend.model.Airport;
import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.repository.*;
import com.codecool.fwu_backend.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/flights")
public class FlightsController {

    private AvailableFlightStorage flightStorage;
    private BookedFlightStorage bookedFlightStorage;
    private MovieStorage movieStorage;
    private PublicTransportRepository publicTransportRepository;
    private AirportRepository airportRepository;
    private ProductRepository productRepository;
    private TravelAgentStorage travelAgentStorage;

    public FlightsController(AvailableFlightStorage flightStorage,
                                 MovieStorage movieStorage,
                                 PublicTransportRepository publicTransportRepository,
                                 AirportRepository airportRepository,
                                 ProductRepository productRepository,
                                 TravelAgentStorage travelAgentStorage,
                                 BookedFlightStorage bookedFlightStorage) {
        this.flightStorage = flightStorage;
        this.movieStorage = movieStorage;
        this.publicTransportRepository = publicTransportRepository;
        this.airportRepository = airportRepository;
        this.productRepository = productRepository;
        this.travelAgentStorage = travelAgentStorage;
        this.bookedFlightStorage = bookedFlightStorage;
    }


    @GetMapping("/")
    public List<Flight> listFlights() {
        return flightStorage.findAll();

    }


    @GetMapping("list")
    public List<Flight> getFlights(@RequestParam String from,
                                   @RequestParam String to,
                                   @RequestParam String when) {
        from = from.toUpperCase();
        to = to.toUpperCase();
        when = when.toUpperCase();
        log.info(from, to, when);
        return flightStorage.getFlightsByCityFromAndCityToAndDate(from, to, when);
    }

    @GetMapping("/airports")
    public List<Airport> getAirports() {
        return airportRepository.findAll();
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
