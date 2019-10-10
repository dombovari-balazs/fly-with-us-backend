package com.codecool.fwu_backend.model;

import com.codecool.fwu_backend.model.enums.ClassQuality;
import com.codecool.fwu_backend.model.enums.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {


    public void fillUpWithGeneratedValues(){
        Random random = new Random();
        this.classQuality = ClassQuality.getRandomClass();
        this.price = random.nextDouble()*100;
        this.company = Company.getRandomClass();
        this.availableSeats = 200;
        this.seats = Seat.getAmountOfSeats(availableSeats, SeatType.SHORT);
    }

    @Id
    @GeneratedValue
    private Long id;

    private String cityTo;
    private String cityFrom;
    private String date;

    @Enumerated(EnumType.STRING)
    private ClassQuality classQuality;

    private double price;

    @Enumerated(EnumType.STRING)
    private Company company;

    private Queue<Seat> seats;
    private int availableSeats;
    @JsonIgnore
    @ManyToMany()
    @Singular("oneMovie")
    @JoinTable(
            name = "Flight_movies",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "flight_id") }
    )
    private List<Movie> movies = new ArrayList<>();
    
    public int getNumberOfAvailableSeats(){
        return availableSeats;
    }
    public Seat bookSeat(){
        this.availableSeats--;
        return seats.peek();
    }

}
