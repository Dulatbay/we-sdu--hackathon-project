package com.example.productsbackend.repositories;

import com.example.productsbackend.entities.PlaceTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceTableRepository extends JpaRepository<PlaceTable, Long> {}
