package com.codecool.fwu_backend.controller;

import com.codecool.fwu_backend.model.Airport;
import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.model.Movie;
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


    @GetMapping("")
    public List<Flight> listFlights() {
        return flightService.findAllFlight();
    }


    // todo: delete this:  localhost:8080/flights/list?from=budapest&to=barcelona&when=2019-09-24  működiiiiik!
    @GetMapping("list")
    public List<Flight> getFlights(@RequestParam HashMap<String,String> map){
        String from = map.get("from").toUpperCase();
        String to = map.get("to").toUpperCase();
        String when = map.get("when").toUpperCase();

        return flightService.listFlights(from, to, when);

    }
    // todo: it returns everything. Task: implement the DTO
    @GetMapping("/airports")
    public List<Airport> getAirports()
    {
        return flightService.findAllAirport();
    }

    @GetMapping("/bookings")
    public List<Flight> listBookedFlights() {

        return flightService.findAllBooking();
    }

    @PostMapping("book")
    public void bookFlight(@RequestBody Flight flight) {
        flightService.bookFlight(flight);

    }

    @PutMapping("book")
    public void changeBookedFlight(@RequestBody Flight flight) {
        flightService.changeBookedFlight(flight);
    }

    @DeleteMapping("book")
    public void deleteBookedFlight(@RequestBody Flight flight) {
        flightService.deleteBookedFlight(flight);
    }

    @GetMapping("/cities")
    public Map<String,City[]> getCities(){
        return flightService.getAllCity();
    }

    @GetMapping("/{id}/movies")
    public List<Movie> listMovieByFlightId(@PathVariable Long id){
        return flightService.listMovieByFlightId(id);
    }

}
