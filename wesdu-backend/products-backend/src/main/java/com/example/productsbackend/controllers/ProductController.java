package com.example.productsbackend.controllers;

import com.example.productsbackend.dtos.ProductCardDto;
import com.example.productsbackend.dtos.ProductDetailDto;
import com.example.productsbackend.dtos.RequestCreatePlaceDto;
import com.example.productsbackend.dtos.RequestCreateProductDto;
import com.example.productsbackend.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/get-all")
    public ResponseEntity<List<ProductCardDto>> getAllProducts(){
        List<ProductCardDto> result = productService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-detail-by-id/{id}")
    public ResponseEntity<ProductDetailDto> getProductDetailById(@PathVariable("id") long id){
        ProductDetailDto result = productService.getProductDetailById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> createNewProduct(@ModelAttribute RequestCreateProductDto requestCreateProductDto){
        var token = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        requestCreateProductDto.setAuthorId(token.getName());
        productService.createProduct(requestCreateProductDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
