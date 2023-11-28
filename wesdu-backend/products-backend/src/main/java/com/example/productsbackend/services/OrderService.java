package com.example.productsbackend.services;

import com.example.productsbackend.dtos.RequestCreateOrderDto;
import com.example.productsbackend.dtos.RequestCreateProductOrderDto;

public interface OrderService {
    void createProductOrder(RequestCreateProductOrderDto requestCreateProductOrderDto);

    void createOrder(RequestCreateOrderDto requestCreateOrderDto);
}
