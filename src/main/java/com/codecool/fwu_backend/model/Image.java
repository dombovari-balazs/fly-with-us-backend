package com.codecool.fwu_backend.model;

import com.codecool.fwu_backend.model.enums.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@Builder
public class Image {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated
    private City city;

    private String link;

}
