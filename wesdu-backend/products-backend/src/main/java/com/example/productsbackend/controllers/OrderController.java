package com.example.productsbackend.controllers;

import com.example.productsbackend.dtos.RequestCreateOrderDto;
import com.example.productsbackend.dtos.RequestCreateProductOrderDto;
import com.example.productsbackend.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create-product-order")
    public void createOrder(@RequestBody RequestCreateProductOrderDto requestCreateProductOrderDto){
        var token = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        requestCreateProductOrderDto.setUserId(token.getName());
        orderService.createProductOrder(requestCreateProductOrderDto);
    }

    @PostMapping("/create-order")
    public void createOrder(@RequestBody RequestCreateOrderDto requestCreateOrderDto){
        var token = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        requestCreateOrderDto.setUserId(token.getName());
        orderService.createOrder(requestCreateOrderDto);
    }
}
