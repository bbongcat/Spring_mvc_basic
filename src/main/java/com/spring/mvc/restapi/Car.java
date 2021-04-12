package com.spring.mvc.restapi;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class Car {

    private String name;
    private String model;
    private List<String> goods;
}
