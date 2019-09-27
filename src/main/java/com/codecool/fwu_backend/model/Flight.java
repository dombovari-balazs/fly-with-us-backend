package com.codecool.fwu_backend.model;

import com.codecool.fwu_backend.model.enums.ClassQuality;
import com.codecool.fwu_backend.model.enums.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    @ElementCollection
    @Singular
    private List<Movie> movies = new ArrayList<>();
}
