package com.example.productsbackend.mappers;

import com.example.productsbackend.dtos.PlaceCardDto;
import com.example.productsbackend.dtos.PlaceDto;
import com.example.productsbackend.dtos.RequestCreatePlaceDto;
import com.example.productsbackend.entities.Place;
import com.example.productsbackend.repositories.PlaceProductRepository;
import com.example.productsbackend.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PlaceCustomMapper {
    private final ProductRepository productRepository;
    private final PlaceProductRepository placeProductRepository;
    private final ProductCustomMapper productCustomMapper;

    public Place toEntity(RequestCreatePlaceDto createPlaceDto) {
        if (createPlaceDto == null) {
            throw new IllegalArgumentException("RequestCreatePlaceDto is empty");
        }

        Place place = new Place();
        place.setName(createPlaceDto.getName());
        place.setLocation(createPlaceDto.getLocation());
        place.setDescription(createPlaceDto.getDescription());
        place.setAvailability(true);
        place.setAuthorId(createPlaceDto.getAuthorId());
        place.setWorkload(0.0);

        return place;
    }

    public List<PlaceCardDto> toCardDto(List<Place> placeEntities) {
        return placeEntities.stream()
                .map(this::toCardDto)
                .collect(Collectors.toList());
    }

    public PlaceCardDto toCardDto(Place place) {
        if (place == null) {
            throw new IllegalArgumentException("Place is empty");
        }

        PlaceCardDto placeCardDto = new PlaceCardDto();
        placeCardDto.setId(place.getId());
        placeCardDto.setName(place.getName());
        placeCardDto.setDescription(place.getDescription());

        placeCardDto.setRating(100);

        placeCardDto.setWorkload(place.getWorkload());

        return placeCardDto;
    }

    public PlaceDto toDto(Place place) {
        if (place == null) {
            return null;
        }

        PlaceDto placeDto = new PlaceDto();
        placeDto.setId(place.getId());
        placeDto.setName(place.getName());
        var placeProducts = placeProductRepository.findPlaceProductsByPlace(place);
        var products = placeProducts.stream().map(i -> productCustomMapper.toCardDto(i.getProduct(), i.getPrice())).toList();
        placeDto.setProductDtoList(products);
        placeDto.setDescription(place.getDescription());
        return placeDto;
    }

    public List<PlaceDto> toDto(List<Place> place){
        return place.stream().map(this::toDto).collect(Collectors.toList());
    }

}
