package com.codecool.fwu_backend.controller;

import com.codecool.fwu_backend.model.Airport;
import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.model.enums.City;
import com.codecool.fwu_backend.repository.*;
import com.codecool.fwu_backend.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/flights")
@AllArgsConstructor

public class FlightsController {

    private FlightService flightService;
    private BookedFlightStorage bookedFlightStorage;
    private MovieStorage movieStorage;
    private PublicTransportRepository publicTransportRepository;
    private AirportRepository airportRepository;
    private ProductRepository productRepository;
    private TravelAgentStorage travelAgentStorage;



    @GetMapping("")
    public List<Flight> listFlights() {
        return flightService.findAll();
    }


    // todo: delete this:  localhost:8080/flights/list?from=budapest&to=barcelona&when=2019-09-24  működiiiiik!
    @GetMapping("list")
    public List<Flight> getFlights(@RequestParam HashMap<String,String> map){
        String from = map.get("from").toUpperCase();
        String to = map.get("to").toUpperCase();
        String when = map.get("when").toUpperCase();
        return flightService.listFlights(from, to, when);

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

    @GetMapping("/cities")
    public Map<String,City[]> getCities(){
        HashMap<String, City[]> map = new HashMap<>();
        map.put("cities", City.values());
        return map ;
    }
}
