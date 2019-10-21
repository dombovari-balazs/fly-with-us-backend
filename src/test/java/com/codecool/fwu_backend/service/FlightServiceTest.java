package com.codecool.fwu_backend.service;

import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.repository.AvailableFlightStorage;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
class FlightServiceTest {
    @MockBean
    private AvailableFlightStorage flightStorage;

    @Autowired
    private FlightService flightService;

    private String from =  "from";
    private String to =  "to";
    private String when =  "when";
    
    private String fromBad =  "fromko";
    private String toBad =  "toko";
    private String whenBad =  "whenko";


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

        List<Flight> flights = IntStream.range(0, 10).boxed()
                .map(integer -> Flight.builder().cityFrom(from).cityTo(to).date(when).build())
                .collect(Collectors.toList());
        Mockito.when(flightStorage.getFlightsByCityFromAndCityToAndDate(from,to,when)).thenReturn(flights);
        assertEquals(flightService.listFlights(from,to,when).size(), 10);

    }

    @org.junit.jupiter.api.Test
    void findAllFlight() {
    }

    @org.junit.jupiter.api.Test
    void findAllAirport() {
    }

    @org.junit.jupiter.api.Test
    void findAllBooking() {
    }

    @org.junit.jupiter.api.Test
    void bookFlight() {
    }

    @org.junit.jupiter.api.Test
    void changeBookedFlight() {
    }

    @org.junit.jupiter.api.Test
    void deleteBooking() {
    }

    @org.junit.jupiter.api.Test
    void getAllCity() {
    }

    @org.junit.jupiter.api.Test
    void listMovieByFlightId() {
    }

    @org.junit.jupiter.api.Test
    void getAmountOfSeats() {
    }
}