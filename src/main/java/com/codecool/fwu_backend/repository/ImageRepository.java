package com.codecool.fwu_backend.repository;

import com.codecool.fwu_backend.model.Image;
import com.codecool.fwu_backend.model.enums.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Image getImageByCity(City city);
}
