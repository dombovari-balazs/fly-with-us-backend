package com.codecool.fwu_backend.service;

import com.codecool.fwu_backend.model.Airport;
import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.model.Product;
import com.codecool.fwu_backend.model.enums.City;
import com.codecool.fwu_backend.model.enums.SeatType;
import com.codecool.fwu_backend.repository.AirportRepository;
import com.codecool.fwu_backend.repository.AvailableFlightStorage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
class FlightServiceTest {
    @MockBean
    private AvailableFlightStorage flightStorage;

    @MockBean
    private AirportRepository airportRepository;

    @Autowired
    private FlightService flightService;

    @MockBean
    private CityService cityService;

    private final String from =  "from";
    private final String to =  "to";
    private final String when =  "when";
    private final String fromBad =  "fromko";
    private final String toBad =  "toko";
    private final String whenBad =  "whenko";


    /**
     * Lists Flights based on searching parameters: from, to and  when
     *
     * returns a List<FlightDto>.
     *
     * todo: have to mock out flightStorage.
     * how to do that? :D
     *
     *
     */
    @Test
    void listFlights() {

        List<Flight> flightGood = IntStream.range(0, 10).boxed()
                .map(integer -> Flight.builder().cityFrom(from).cityTo(to).date(when).build())
                .collect(Collectors.toList());
        List<Flight> flightBad = IntStream.range(0, 8).boxed()
                .map(integer -> Flight.builder().cityFrom(fromBad).cityTo(fromBad).date(fromBad).build())
                .collect(Collectors.toList());
        Mockito.when(flightStorage.getFlightsByCityFromAndCityToAndDate(from,to,when)).thenReturn(flightGood);
        Mockito.when(flightStorage.getFlightsByCityFromAndCityToAndDate(fromBad,toBad,whenBad)).thenReturn(flightBad);
        assertEquals(flightService.listFlights(from,to,when).size(), 10);

    }

    @org.junit.jupiter.api.Test
    void findAllFlight() {
        int size = 10;
        List<Flight> flightGood = IntStream.range(0, size).boxed()
                .map(integer -> Flight.builder().cityFrom(from).cityTo(to).date(when).build())
                .collect(Collectors.toList());
        List<Flight> flightBad = IntStream.range(0, size).boxed()
                .map(integer -> Flight.builder().cityFrom(fromBad).cityTo(fromBad).date(fromBad).build())
                .collect(Collectors.toList());
        List<Flight> flights = new ArrayList<>();
        flights.addAll(flightBad);
        flights.addAll(flightGood);
        Mockito.when(flightStorage.findAll()).thenReturn(flights);
        assertThat(flightService.findAllFlight()).hasSize(size * 2);

    }

    @org.junit.jupiter.api.Test
    void findAllAirport() {
        int size = 10;
        List<Airport> airports = IntStream.range(0, size).boxed()
                .map(Integer -> (Airport
                        .builder()
                        .city(City.BUDAPEST)
                        .name("EXAMPLE")
                        .build()))
                .collect(Collectors.toList());
        Mockito.when(airportRepository.findAll()).thenReturn(airports);
        assertThat(flightService.findAllAirport()).containsSequence(airports);
    }

    @org.junit.jupiter.api.Test
    void findAllBooking() {
        //TODO implement in code DUH...
    }

    @org.junit.jupiter.api.Test
    void bookFlight() {

    }

    @org.junit.jupiter.api.Test
    void deleteBooking() {
    }

    @org.junit.jupiter.api.Test
    void getAllCity() {
        assertThat(flightService.getAllCity()).allSatisfy((s, cities) -> Arrays.equals(cities, City.values()));
    }

    @org.junit.jupiter.api.Test
    void listMovieByFlightId() {

    }

    @org.junit.jupiter.api.Test
    void getAmountOfSeats() {
        assertThat(flightService.getAmountOfSeats(10, SeatType.PREMIUM))
                .allMatch(seat -> seat.getType().equals(SeatType.PREMIUM));
    }
}