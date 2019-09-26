package com.codecool.fwu_backend.model.enums;

import java.util.Random;

public enum City {
    BUDAPEST,
    NARNIA,
    VIENNA,
    TOKYO,
    PEKING,
    LONDON,
    PARIS,
    MADRID,
    BARCELONA,
    COPENHAGEN,
    LISBON,
    ROME,
    KRAKOW,
    PRAGUE,
    OSLO;

    public static City getRandomCity(){
        Random random = new Random();
        return City.values()[random.nextInt(City.values().length)];
    }

}
