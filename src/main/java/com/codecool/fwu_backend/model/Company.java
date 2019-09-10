package com.codecool.fwu_backend.model;

import java.util.Random;

public enum Company {

    FLYINGPINGUIN,
    CHICKENWINGS,
    PURPELUNICRON,
    BUZZAIR,
    MATYZZAIR,
    BORABORA,
    BESTAIRLINEEVERINTHEWORD,
    EASYPISYLEMONSQUISY,
    FIREINTHEAIR,
    BLUEBLUEBLUE;

    static Random random = new Random();

    public static Company getRandomClass(){
        return Company.values()[random.nextInt(Company.values().length)];
    }
}
