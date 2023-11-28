package com.example.productsbackend.dtos;

import lombok.Data;


@Data
public class PlaceCardDto {
    private long id;
    private String name;
    private String description;
    private double rating;
    private double workload;
}
