package com.example.productsbackend.services.impl;

import com.example.productsbackend.dtos.RequestCreateOrderDto;
import com.example.productsbackend.dtos.RequestCreateProductOrderDto;
import com.example.productsbackend.entities.Order;
import com.example.productsbackend.entities.ProductOrder;
import com.example.productsbackend.repositories.OrderRepository;
import com.example.productsbackend.repositories.PlaceRepository;
import com.example.productsbackend.repositories.ProductOrderRepository;
import com.example.productsbackend.repositories.ProductRepository;
import com.example.productsbackend.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final ProductOrderRepository productOrderRepository;
    private final ProductRepository productRepository;
    private final PlaceRepository placeRepository;
    private final OrderRepository orderRepository;

    @Override
    public void createProductOrder(RequestCreateProductOrderDto requestCreateProductOrderDto) {
        log.info("requestCreateOrderDto: {}", requestCreateProductOrderDto);
        var place = placeRepository.findById(requestCreateProductOrderDto.getPlaceId())
                .orElseThrow(() -> new IllegalArgumentException("Place doesn't exist"));
        var product = productRepository.findById(requestCreateProductOrderDto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product doesn't exist"));
        ProductOrder productOrder = new ProductOrder();
        productOrder.setProduct(product);
        productOrder.setPlace(place);
        productOrder.setQuantity(requestCreateProductOrderDto.getQuantity());
        productOrderRepository.save(productOrder);
    }

    @Override
    public void createOrder(RequestCreateOrderDto requestCreateOrderDto) {
        Order order = new Order();
        order.setUserId(requestCreateOrderDto.getUserId());
        order.setCreatedAt(LocalDateTime.now());
        var productOrders = productOrderRepository.findAllById(requestCreateOrderDto.getProductOrderIds());
        if(productOrders.size() != requestCreateOrderDto.getProductOrderIds().size())
            throw new IllegalArgumentException("Product oder doesn't exist");
        order.setProductOrders(productOrders);
        order.setType(requestCreateOrderDto.getType());
        order.setStatus(requestCreateOrderDto.getStatus());
        order.setExpiredAt(requestCreateOrderDto.getExpiredAt());
        order.setDeliveryTo(requestCreateOrderDto.getDeliveryTo());
        orderRepository.save(order);
    }
}
