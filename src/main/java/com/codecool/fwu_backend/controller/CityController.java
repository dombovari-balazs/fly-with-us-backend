package com.codecool.fwu_backend.controller;

import com.codecool.fwu_backend.model.Image;
import com.codecool.fwu_backend.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
@AllArgsConstructor
@CrossOrigin

public class CityController {
    private CityService cityService;

    @GetMapping("/{name}/image")
    public Image getImageForCity(@PathVariable String name){
        return cityService.getImage(name);
    }
}
