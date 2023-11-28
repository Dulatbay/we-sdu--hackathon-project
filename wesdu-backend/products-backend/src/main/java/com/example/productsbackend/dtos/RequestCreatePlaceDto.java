package com.example.productsbackend.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class RequestCreatePlaceDto {
    private String name;
    private String location;
    private String description;
    @JsonIgnore
    private String authorId;
}
