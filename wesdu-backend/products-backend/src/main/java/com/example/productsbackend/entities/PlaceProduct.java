package com.example.productsbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "place_product", schema = "schema_wesdu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name="price", nullable = false)
    private double price;

    @Column(name="is_availability", nullable = false)
    private boolean isAvailability;
}
