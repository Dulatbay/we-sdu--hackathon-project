package com.example.productsbackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductCardDto {
    private long id;
    private String name;
    private double price;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("old_price")
    private double oldPrice;
}
