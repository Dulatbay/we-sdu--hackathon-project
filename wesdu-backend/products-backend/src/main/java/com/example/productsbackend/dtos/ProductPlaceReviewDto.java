package com.example.productsbackend.dtos;

import lombok.Data;

@Data
public class ProductPlaceReviewDto {
    private long id;
    private String username;
    private String description;
    private double rating;
}
