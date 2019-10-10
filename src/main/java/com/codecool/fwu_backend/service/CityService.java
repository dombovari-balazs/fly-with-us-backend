package com.codecool.fwu_backend.service;

import com.codecool.fwu_backend.model.Image;
import com.codecool.fwu_backend.model.enums.City;
import com.codecool.fwu_backend.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityService {
    private ImageRepository imageRepository;

    public Image getImage(String name){
        return imageRepository.getImageByCity(City.valueOf(name.toUpperCase()));
    }
}
