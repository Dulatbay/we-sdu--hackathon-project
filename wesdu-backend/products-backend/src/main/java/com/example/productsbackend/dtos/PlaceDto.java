package com.example.productsbackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

// placeDto for select bar
@Data
public class PlaceDto {
    private long id;
    private String name;
    private String description;

    @JsonProperty("product_dto_list")
    private List<ProductCardDto> productDtoList;
}
