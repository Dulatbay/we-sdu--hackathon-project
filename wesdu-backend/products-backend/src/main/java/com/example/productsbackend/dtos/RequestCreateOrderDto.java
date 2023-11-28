package com.example.productsbackend.dtos;

import com.example.productsbackend.entities.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RequestCreateOrderDto {
    @JsonIgnore
    private String userId;
    @JsonProperty("product_order_ids")
    private List<Long> productOrderIds;
    @JsonProperty("expired_at")
    private LocalDateTime expiredAt;
    @JsonProperty("delivery_to")
    private String deliveryTo;
    private Order.Type type;
    private Order.Status status;
}
