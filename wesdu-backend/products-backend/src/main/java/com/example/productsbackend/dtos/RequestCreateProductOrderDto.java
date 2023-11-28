package com.example.productsbackend.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestCreateProductOrderDto {
    @JsonProperty("product_id")
    private long productId;
    @JsonIgnore
    private String userId;
    @JsonProperty("place_id")
    private long placeId;
    private int quantity;
}
