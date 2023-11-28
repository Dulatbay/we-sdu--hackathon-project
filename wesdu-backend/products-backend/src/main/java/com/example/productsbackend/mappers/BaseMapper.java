package com.example.productsbackend.mappers;

import java.util.List;

public interface BaseMapper<E, D> {
    E toEntity();
    D toDto();
    List<E> toEntity(List<D> dtoList);
    List<D> toDTO(List<E> entityList);
}
