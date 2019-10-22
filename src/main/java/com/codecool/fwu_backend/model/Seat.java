package com.codecool.fwu_backend.model;

import com.codecool.fwu_backend.model.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Seat {


    @Id
    @GeneratedValue
    private Long id;

    private SeatType type;

    private int position;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private FWUAppUser user;

    @JsonIgnore
    @ManyToOne
    private Flight flight;

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", type=" + type +
                ", position=" + position +
                ", user=" + user +
                ", flight=" + flight +
                '}';
    }
}
