package com.codecool.fwu_backend.component;

import java.util.Random;

public enum ClassQuality {

    FIRST,
    SECOND,
    TOURIST,
    ECONOMY;

    static Random random = new Random();

    public static ClassQuality getRandomClass(){
        return ClassQuality.values()[random.nextInt(ClassQuality.values().length)];
    }
}
