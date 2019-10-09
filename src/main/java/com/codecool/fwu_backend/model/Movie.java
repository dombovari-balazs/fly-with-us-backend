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
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private int length;

    @JsonIgnore
    @Singular("oneFlight")
    @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL)
    private List<Flight> flights = new ArrayList<>();

}
