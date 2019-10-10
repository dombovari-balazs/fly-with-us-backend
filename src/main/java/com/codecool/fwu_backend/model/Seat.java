package com.codecool.fwu_backend.model;

import com.codecool.fwu_backend.model.enums.SeatType;
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
    @OneToOne
    private User user;


    @ManyToOne
    private Flight flight;

}
