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
import java.util.*;


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

    @OneToMany(mappedBy = "flight", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Seat> seats = new LinkedList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "flights")
    @Singular("oneMovie")
    private List<Movie> movies = new ArrayList<>();
    


}
