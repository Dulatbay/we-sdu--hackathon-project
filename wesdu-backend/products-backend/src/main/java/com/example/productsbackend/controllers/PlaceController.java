package com.example.productsbackend.controllers;

import com.example.productsbackend.dtos.PlaceCardDto;
import com.example.productsbackend.dtos.PlaceDto;
import com.example.productsbackend.dtos.RequestCreatePlaceDto;
import com.example.productsbackend.services.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/places")
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping("/all")
    public ResponseEntity<List<PlaceDto>> getAllPlaces(){
        var result = placeService.getAllPlaces();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/cards")
    public ResponseEntity<List<PlaceCardDto>> getPlaceById(){
        var result = placeService.getAllPlaceCards();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewPlace(RequestCreatePlaceDto requestCreatePlaceDto){
        var token = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        requestCreatePlaceDto.setAuthorId(token.getName());
        placeService.createPlace(requestCreatePlaceDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{product-id}/add-place/{place-id}")
    public ResponseEntity<Void> addPlaceToProduct(@PathVariable("product-id") Long productId,
                                                  @PathVariable("place-id") Long placeId,
                                                  @RequestParam("price") Double price
                                                  ){
        placeService.addPlaceToProduct(productId, placeId, price);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
