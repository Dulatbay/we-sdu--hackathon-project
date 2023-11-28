package com.example.productsbackend.repositories;

import com.example.productsbackend.entities.TableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableTypeRepository extends JpaRepository<TableType, Long> {}
