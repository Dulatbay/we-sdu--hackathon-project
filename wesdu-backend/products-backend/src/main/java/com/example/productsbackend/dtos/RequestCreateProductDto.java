package com.example.productsbackend.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class RequestCreateProductDto {
    private String name;
    private String description;

    @Nullable
    private MultipartFile multipartFile;

    @JsonIgnore
    private String authorId;

    @Nullable
    private List<Long> tagIds;
}
