package com.example.productsbackend.mappers;

import com.example.productsbackend.dtos.ProductCardDto;
import com.example.productsbackend.dtos.RequestCreateProductDto;
import com.example.productsbackend.entities.Product;
import com.example.productsbackend.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductCustomMapper {
    private final TagRepository tagRepository;

    public ProductCardDto toCardDto(Product product, double price){
        ProductCardDto productCardDto = new ProductCardDto();
        productCardDto.setId(product.getId());
        productCardDto.setName(product.getName());
        productCardDto.setPrice(price);
        productCardDto.setOldPrice(-1);
        productCardDto.setImageUrl(product.getImageUrl());
        return productCardDto;
    }

    public Product toEntity(RequestCreateProductDto requestCreateProductDto){
        Product product = new Product();
        product.setAuthorId(requestCreateProductDto.getAuthorId());
        var tags = tagRepository.findAllById(requestCreateProductDto.getTagIds());
        if(tags.size() != requestCreateProductDto.getTagIds().size()) throw new IllegalArgumentException("All tags don't exist");
        product.setTags(tags);
        product.setName(requestCreateProductDto.getName());
        product.setDescription(requestCreateProductDto.getDescription());
        product.setImageUrl("https://amiel.club/uploads/posts/2022-03/1647563505_1-amiel-club-p-kartinki-burgerov-1.jpg");
        return product;
    }

}
