package com.example.sample.Service;

import com.example.sample.DTO.OrderRegisterDTO;
import com.example.sample.DTO.OrderResponseDTO;
import com.example.sample.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    OrderResponseDTO addOrder(OrderRegisterDTO registerDTO, User user);

    OrderResponseDTO getOrderById(Long id);

    Page<OrderResponseDTO> getAllOrders(Pageable pageable);

    OrderResponseDTO updateOrder(Long id, OrderRegisterDTO registerDTO);

    void deleteById(Long id);

}
