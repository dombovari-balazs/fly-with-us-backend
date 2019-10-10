package com.codecool.fwu_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Seat {


    private Long id;

    private SeatType type;

    private int position;

    public static Queue<Seat> getAmountOfSeats(int amount, SeatType seatType){
        return IntStream.range(0, amount).boxed()
                .map(integer ->
                        Seat.builder()
                                .position(integer)
                                .type(seatType)
                                .build()
                )
                .collect(Collectors.toCollection(PriorityQueue::new));
    }
}
