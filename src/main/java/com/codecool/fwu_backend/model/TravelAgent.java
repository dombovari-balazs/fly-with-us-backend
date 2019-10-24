package com.codecool.fwu_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
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

    @Singular
    @OneToMany(mappedBy = "travelAgent", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Flight> flights;
}
