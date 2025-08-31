package com.example.sample.DTO;

import com.example.sample.Common.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {

    private Long id;
    private String productName;
    private Double amount;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private Long userId;
    private String userName;

}
