package com.example.productsbackend.repositories;

import com.example.productsbackend.entities.Place;
import com.example.productsbackend.entities.PlaceProduct;
import com.example.productsbackend.entities.PlaceTable;
import com.example.productsbackend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PlaceProductRepository extends JpaRepository<PlaceProduct, Long> {
    List<PlaceProduct> findPlaceProductsByPlace(Place place);

    @Query("SELECT p.product.id, MIN(p.price) FROM PlaceProduct p GROUP BY p.product.id")
    List<Object[]> findAveragePricesByProductId();

//    @Query("SELECT p.product.id, MIN(p.price) FROM PlaceProduct p WHERE p.id = :id GROUP BY p.product.id")
//    List<Object[]> findAveragePricesByProductId(Long id);
}
