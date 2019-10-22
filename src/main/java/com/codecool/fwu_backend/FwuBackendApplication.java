package com.codecool.fwu_backend;

import com.codecool.fwu_backend.model.*;
import com.codecool.fwu_backend.model.enums.City;
import com.codecool.fwu_backend.model.enums.SeatType;
import com.codecool.fwu_backend.repository.*;
import com.codecool.fwu_backend.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@SpringBootApplication
@Slf4j
public class FwuBackendApplication {

    private AvailableFlightStorage flightStorage;
    private FlightService flightService;
    private MovieStorage movieStorage;
    private PublicTransportRepository publicTransportRepository;
    private AirportRepository airportRepository;
    private ProductRepository productRepository;
    private TravelAgentStorage travelAgentStorage;
    private ImageRepository imageRepository;
    private SeatRepository seatRepository;

    public static void main(String[] args) {
        SpringApplication.run(FwuBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            //flightService.addRandomAmountOfFlight(City.BUDAPEST.name(),City.BARCELONA.name(), "2019-09-24");
            //log.info(flightService.getOneFlight().toString());

            Image budapest = Image.builder()
                    .city(City.BUDAPEST)
                    .link("https://www.thenational.ae/image/policy:1.906591:1567660612/lf04-SEP-travel-budapest01.jpg?f=16x9&w=1200&$p$f$w=42f8404")
                    .build();
            imageRepository.save(budapest);

            Image barcelona = Image.builder()
                    .city(City.BARCELONA)
                    .link("")
                    .build();
            imageRepository.save(barcelona);


            Movie movie1 = Movie.builder()
                    .title("Airplane!")
                    .length(120)
                    .build();

            List<Seat> seats = flightService.getAmountOfSeats(200, SeatType.SHORT);
            List<Seat> seats2 = flightService.getAmountOfSeats(200, SeatType.SHORT);
            Flight example = Flight.builder()
                    .cityFrom(City.BUDAPEST.name())
                    .cityTo(City.BARCELONA.name())
                    .date("2019-09-24")
                    .oneMovie(movie1)
                    .seats(seats)
                    .build();
            seats.forEach(seat -> seat.setFlight(example));
            example.fillUpWithGeneratedValues();
            movie1.setFlights(Collections.singletonList(example));
            flightStorage.save(example);
            movieStorage.save(movie1);

            TravelAgent travelAgent = TravelAgent.builder()
                    .name("WizHair")
                    .rating(5f)
                    .website("localhost")
                    .flight(example)
                    .build();


            travelAgentStorage.save(travelAgent);



            Flight example2 = Flight.builder()
                    .cityFrom(City.BUDAPEST.name())
                    .cityTo(City.BARCELONA.name())
                    .date("2019-09 -25")
                    .seats(seats2)
                    .build();
            example2.fillUpWithGeneratedValues();
            seats2.forEach(seat -> seat.setFlight(example2));

            flightStorage.saveAndFlush(example2);


            PublicTransport bkk = PublicTransport.builder()
                    .name("BKK")
                    .build();
            bkk.fillUpGeneratedTimes();
            publicTransportRepository.save(bkk);

            Airport liszt_ferenc_airport = Airport.builder()
                    .city(City.BUDAPEST)
                    .name("Liszt Ferenc Airport")
                    .publicTransport(bkk)
                    .flights(flightStorage.findAll())
                    .build();
            airportRepository.save(liszt_ferenc_airport);

            Product beer = Product.builder()
                    .name("Beer")
                    .description("Beer is one of the oldest and most widely consumed alcoholic drinks in the world. It is also the third most popular drink overall after water and tea. ")
                    .oneAirport(liszt_ferenc_airport)
                    .build();

            productRepository.save(beer);
            liszt_ferenc_airport.setProducts(productRepository.findAll());
            airportRepository.save(liszt_ferenc_airport);



        };
    }
}