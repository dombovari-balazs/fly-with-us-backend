package com.codecool.fwu_backend.model;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelAgent {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private float rating;
    private String website;

    @ElementCollection
    @Singular
    List<Flight> flights = new ArrayList<>();
}
