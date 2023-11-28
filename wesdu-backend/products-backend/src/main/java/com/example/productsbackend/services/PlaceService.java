package com.example.productsbackend.services;

import com.example.productsbackend.dtos.PlaceCardDto;
import com.example.productsbackend.dtos.PlaceDto;
import com.example.productsbackend.dtos.RequestCreatePlaceDto;

import java.util.List;

public interface PlaceService {
    List<PlaceDto> getAllPlaces();

    void createPlace(RequestCreatePlaceDto requestCreatePlaceDto);

    List<PlaceCardDto> getAllPlaceCards();

    void addPlaceToProduct(Long productId, Long placeId, Double price);
}
