package com.example.sample.Entity;

import com.example.sample.Common.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name" , nullable = false)
    private String productName;

    @Column(name = "product_type" , nullable = false)
    private String productType;

    @Column(name = "amount" , nullable = false)
    private Double amount;

    @Column(name = "order_date" , nullable = false)
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status" , nullable = false)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name  = "user_id", nullable = false)
    private User user;

}
