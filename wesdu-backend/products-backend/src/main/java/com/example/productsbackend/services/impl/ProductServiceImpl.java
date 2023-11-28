package com.example.productsbackend.services.impl;

import com.example.productsbackend.dtos.ProductCardDto;
import com.example.productsbackend.dtos.ProductDetailDto;
import com.example.productsbackend.dtos.RequestCreateProductDto;
import com.example.productsbackend.exceptions.DbObjectNotFoundException;
import com.example.productsbackend.mappers.ProductCustomMapper;
import com.example.productsbackend.repositories.PlaceProductRepository;
import com.example.productsbackend.repositories.PlaceRepository;
import com.example.productsbackend.repositories.ProductRepository;
import com.example.productsbackend.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductCustomMapper productCustomMapper;
    private final ProductRepository productRepository;
    private final PlaceProductRepository placeProductRepository;
    private final PlaceRepository placeRepository;

    @Override
    public ProductDetailDto getProductDetailById(long id) {
        var entity = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Object not found"));
        ProductDetailDto productDetailDto = new ProductDetailDto();
        productDetailDto.setId(entity.getId());
        productDetailDto.setProductPlaceReviewDtos(null);
        productDetailDto.setName(entity.getName());
        productDetailDto.setPlaceDtoList(null);
        return productDetailDto;
    }

    @Override
    public void createProduct(RequestCreateProductDto requestCreateProductDto) {
        var entity = productCustomMapper.toEntity(requestCreateProductDto);
        productRepository.save(entity);
    }

    @Override
    public List<ProductCardDto> getAll() {
        var averagePricesByProductId = placeProductRepository.findAveragePricesByProductId();
        log.info(String.valueOf(averagePricesByProductId.size()));
        return averagePricesByProductId.stream()
                .map(entry -> {
                    log.info("{} : {}", entry[0], entry[1]);
                    return productCustomMapper.toCardDto(productRepository.findById(Long.parseLong(entry[0].toString()))
                                    .orElseThrow(
                                            () -> new DbObjectNotFoundException(HttpStatus.NOT_FOUND.toString(),
                                                    "Product doesn't exist")),
                            Double.parseDouble(entry[1].toString()));
                })
                .collect(Collectors.toList());
    }

}
