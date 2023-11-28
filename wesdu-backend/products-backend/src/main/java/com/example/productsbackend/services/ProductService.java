package com.example.productsbackend.services;

import com.example.productsbackend.dtos.ProductCardDto;
import com.example.productsbackend.dtos.ProductDetailDto;
import com.example.productsbackend.dtos.RequestCreateProductDto;

import java.util.List;

public interface ProductService {

    ProductDetailDto getProductDetailById(long id);

    void createProduct(RequestCreateProductDto requestCreateProductDto);

    List<ProductCardDto> getAll();
}
