package com.example.sample.ServiceImpl;

import com.example.sample.DTO.OrderRegisterDTO;
import com.example.sample.DTO.OrderResponseDTO;
import com.example.sample.Entity.Orders;
import com.example.sample.Entity.User;
import com.example.sample.Exception.ResourceNotFoundException;
import com.example.sample.Mapper.OrderMapper;
import com.example.sample.Repo.OrderRepo;
import com.example.sample.Repo.UserRepo;
import com.example.sample.Service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;

    @Override
    public OrderResponseDTO addOrder(OrderRegisterDTO registerDTO, User user) {
        Orders order = orderMapper.toEntity(registerDTO);
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        return orderMapper.toDTO(orderRepo.save(order));
    }

    @Override
    public OrderResponseDTO getOrderById(Long id) {
        Orders order = orderRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        return orderMapper.toDTO(order);
    }

    @Override
    public Page<OrderResponseDTO> getAllOrders(Pageable pageable) {
        return orderRepo.findAll(pageable).map(orderMapper::toDTO);
    }

    @Override
    public OrderResponseDTO updateOrder(Long id, OrderRegisterDTO registerDTO) {
        Orders order = orderRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        orderMapper.updateFromRequest(registerDTO, order);
        return orderMapper.toDTO(orderRepo.save(order));
    }

    @Override
    public void deleteById(Long id) {
        if (!orderRepo.existsById(id)) throw new ResourceNotFoundException("Order not found with id: " + id);
        orderRepo.deleteById(id);
    }



}
