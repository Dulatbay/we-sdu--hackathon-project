package com.example.productsbackend.repositories;

import com.example.productsbackend.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    boolean existsByName(String name);
}
