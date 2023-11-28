package com.example.usersbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "order", schema = "schema_wesdu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @ManyToOne
    @JoinColumn(name = "product_order_id")
    private ProductOrder productOrder;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    @Column(name = "delivery_to", nullable = false)
    private String deliveryTo;

    enum Status {
        inQueue, cookingInProgress, deliveryInProgress, completed, rejected, waitingForClient, reviewOrder
    }

    @Column(name="status", nullable = false)
    private Status status;

    @PrePersist
    public void setPostDate() {
        this.createdAt = LocalDateTime.now();
    }
}
