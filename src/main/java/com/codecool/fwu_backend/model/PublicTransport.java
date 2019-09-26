package com.codecool.fwu_backend.model;

import com.codecool.fwu_backend.model.enums.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.IntStream;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublicTransport {
    /** This class is made to manage when can you travel from the City to the Airport and backwards as well.
     *
     */
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    /** The city where the transport is.
     *
     */

    @ElementCollection
    private List<String> toAirport = new ArrayList<>(); // most akkor mivan?

    @ElementCollection
    private List<String> toCity = new ArrayList<>();

    public void fillUpGeneratedTimes(){
        toAirport = new ArrayList<>();
        toCity = new ArrayList<>();
        ArrayList<String> times = new ArrayList<>();
        for (int i = 0; i < 15 ; i++) {
            times.add( (5 + i) + ":15");
        }

        List<String> times2 = new ArrayList<>();
        for (int i = 0; i < 15 ; i++) {
            times2.add( (5 + i) + ":45");
        }

        for (int i = 0; i < 20; i++) {
            toAirport.add("2019-10-" + i + "  " + times.get(2));
            toCity.add("2019-10-" + i + "  " + times2.get(2));
        }

    }


}
