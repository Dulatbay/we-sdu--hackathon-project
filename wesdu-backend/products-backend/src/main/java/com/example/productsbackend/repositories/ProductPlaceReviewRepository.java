package com.example.productsbackend.repositories;

import com.example.productsbackend.entities.ProductPlaceReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPlaceReviewRepository extends JpaRepository<ProductPlaceReview, Long> {}
