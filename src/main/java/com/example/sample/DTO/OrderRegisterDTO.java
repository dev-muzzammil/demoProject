package com.example.sample.DTO;

import com.example.sample.Common.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRegisterDTO {

    @NotBlank(message = "Product name is required")
    private String productName;

    @NotNull(message = "Product amount is required")
    private Double amount;

    private LocalDateTime orderDate;

    @NotNull(message = "Order status is required")
    private OrderStatus status;

    private Long userId;

}
