package com.example.productsbackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductDetailDto {
    private long id;
    private String name;
    private String location;
    private String description;
    private double rating;

    @JsonProperty("places")
    private List<PlaceDto> placeDtoList;
    @JsonProperty("reviews")
    private List<ProductPlaceReviewDto> productPlaceReviewDtos;

    @Data
    static class PlaceDto {
        private long id;
        private String name;
    }
}
