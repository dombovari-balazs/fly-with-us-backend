package com.codecool.fwu_backend.service;

import com.codecool.fwu_backend.model.Airport;
import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.model.Movie;
import com.codecool.fwu_backend.model.dto.FlightDto;
import com.codecool.fwu_backend.model.enums.City;
import com.codecool.fwu_backend.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class FlightService {

    private AvailableFlightStorage flightStorage;
    private AirportRepository airportRepository;
    private BookedFlightStorage bookedFlightStorage;
    private MovieStorage movieStorage;  // todo: naming convention pls :DD
    private PublicTransportRepository publicTransportRepository;
    private ProductRepository productRepository;
    private TravelAgentStorage travelAgentStorage;

    @Autowired
    private Random random;



    public void addRandomAmountOfFlight(String to, String from, String when){
        Stream.generate(() -> Flight.builder()
                .cityFrom(from)
                .cityTo(to)
                .date(when)
                .build() )
                .limit(random.nextInt(20))
                .forEach(flight -> {
                    flight.fillUpWithGeneratedValues();
                    flightStorage.save(flight);
                });
    }
    public Flight getOneFlight(){
        return flightStorage.findAll().get(0);
    }

    public List<FlightDto> listFlights(String from, String to, String when){
        List<Flight> flights = flightStorage.getFlightsByCityFromAndCityToAndDate(from, to, when);
        return flights.stream().map(FlightDto::new).collect(Collectors.toList());

    }

    public List<Flight> findAllFlight() {
        return flightStorage.findAll();
    }

    public List<Airport> findAllAirport() {

        return airportRepository.findAll();
    }

    public List<Flight> findAllBooking() {
        return bookedFlightStorage.findAll();
    }

    public boolean bookFlight(Long flightID) {
        Flight one = flightStorage.getOne(flightID);
        bookedFlightStorage.save(one);
        return true;
    }

    public void changeBookedFlight(Flight flight) {
        bookedFlightStorage.deleteById(flight.getId());
        bookedFlightStorage.save(flight);
    }

    public void deleteBookedFlight(Long flightID) {
        bookedFlightStorage.deleteById(flightID);
    }

    public Map<String, City[]> getAllCity() {
        HashMap<String, City[]> map = new HashMap<>();
        map.put("cities", City.values());
        return map;
    }

    public List<Movie> listMovieByFlightId(Long id) {
        return flightStorage.getOne(id).getMovies();
    }
}
