package com.example.productsbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "place_table", schema = "schema_wesdu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "table_type_id")
    private TableType tableType;

    @Column(name = "index", nullable = false, unique = true)
    private int index;
}
