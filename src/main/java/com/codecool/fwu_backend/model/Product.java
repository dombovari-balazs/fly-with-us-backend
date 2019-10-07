package com.codecool.fwu_backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Product")

public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @Singular("oneAirport")
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "products")
    private List<Airport> airportWhereAvailable;

}
