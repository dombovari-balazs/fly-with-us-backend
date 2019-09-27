package com.codecool.fwu_backend.model;

import com.codecool.fwu_backend.model.enums.City;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Airport")


public class Airport {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @Enumerated(EnumType.STRING)
    private City city;

    @ElementCollection
    private List<Flight> flights = new ArrayList<>();

    @OneToOne
    private PublicTransport publicTransport;

    @JsonIgnore
    @Singular()
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Airport_Products",
            joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = { @JoinColumn(name = "airport_id") }
    )
    private List<Product> products;

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", flights=" + flights +
                ", publicTransport=" + publicTransport +
                ", products=" + products +
                '}';
    }
}
