package com.example.productsbackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductCardWithSaleDto {
    private long id;
    private String name;
    private String location;
    private double price;
    @JsonProperty("old_price")
    private double oldPrice;
}
