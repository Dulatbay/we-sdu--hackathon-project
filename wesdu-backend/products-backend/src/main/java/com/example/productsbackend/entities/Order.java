package com.example.productsbackend.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    private String userId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    @Column(name = "delivery_to", nullable = false)
    private String deliveryTo;

    public enum Status {
        inQueue("inQueue"),
        cookingInProgress("cookingInProgress"),
        deliveryInProgress("deliveryInProgress"),
        completed("completed"),
        rejected("rejected"),
        waitingForClient("waitingForClient"),
        reviewOrder("reviewOrder");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @JsonCreator
        public static Status fromValue(String value) {
            for (Status type : Status.values()) {
                if (type.value.equalsIgnoreCase(value)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown enum value: " + value);
        }
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public enum Type {
        delivery("delivery"), pickup("pickup");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @JsonCreator
        public static Type fromValue(String value) {
            for (Type type : Type.values()) {
                if (type.value.equalsIgnoreCase(value)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown enum value: " + value);
        }
    }

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_products", schema = "schema_wesdu",
            joinColumns = @JoinColumn(name = "product_order_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<ProductOrder> productOrders;

    @PrePersist
    public void setPostDate() {
        this.createdAt = LocalDateTime.now();
    }
}
