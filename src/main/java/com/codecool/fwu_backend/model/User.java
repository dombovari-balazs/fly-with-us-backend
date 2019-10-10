package com.codecool.fwu_backend.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
