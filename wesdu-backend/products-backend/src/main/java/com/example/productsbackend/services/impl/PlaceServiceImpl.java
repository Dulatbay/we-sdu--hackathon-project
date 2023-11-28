package com.example.productsbackend.services.impl;

import com.example.productsbackend.dtos.PlaceCardDto;
import com.example.productsbackend.dtos.PlaceDto;
import com.example.productsbackend.dtos.RequestCreatePlaceDto;
import com.example.productsbackend.entities.PlaceProduct;
import com.example.productsbackend.exceptions.DbObjectNotFoundException;
import com.example.productsbackend.mappers.PlaceCustomMapper;
import com.example.productsbackend.repositories.PlaceProductRepository;
import com.example.productsbackend.repositories.PlaceRepository;
import com.example.productsbackend.repositories.ProductRepository;
import com.example.productsbackend.services.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;
    private final ProductRepository productRepository;
    private final PlaceProductRepository placeProductRepository;
    private final PlaceCustomMapper placeCustomMapper;

    @Override
    public List<PlaceDto> getAllPlaces() {
        var placeEntities = placeRepository.findAll();
        return placeCustomMapper.toDto(placeEntities);
    }

    @Override
    public void createPlace(RequestCreatePlaceDto requestCreatePlaceDto) {
        if(placeRepository.existsByName(requestCreatePlaceDto.getName()))
            throw new IllegalArgumentException("Place already added");
        var placeEntity = placeCustomMapper.toEntity(requestCreatePlaceDto);
        placeRepository.save(placeEntity);
    }

    @Override
    public List<PlaceCardDto> getAllPlaceCards() {
        var place = placeRepository.findAll();
        return placeCustomMapper.toCardDto(place);
    }

    @Override
    public void addPlaceToProduct(Long productId, Long placeId, Double price) {
        var product = productRepository.findById(productId).orElseThrow(
                () -> new DbObjectNotFoundException(HttpStatus.NOT_FOUND.toString(), "Product doesn't exist"));
        var place = placeRepository.findById(placeId).orElseThrow(
                () -> new DbObjectNotFoundException(HttpStatus.NOT_FOUND.toString(), "Place doesn't exist"));
        PlaceProduct placeProduct = new PlaceProduct();
        placeProduct.setProduct(product);
        placeProduct.setPlace(place);
        placeProduct.setAvailability(true);
        placeProduct.setPrice(price);
        placeProductRepository.save(placeProduct);
    }
}
