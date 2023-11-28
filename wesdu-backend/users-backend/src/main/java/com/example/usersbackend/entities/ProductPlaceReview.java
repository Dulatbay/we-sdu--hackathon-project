package com.example.usersbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_place_review", schema = "schema_wesdu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPlaceReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "rating", nullable = false)
    private byte rating;

}
