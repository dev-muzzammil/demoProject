package com.example.sample.Mapper;

import com.example.sample.DTO.OrderRegisterDTO;
import com.example.sample.DTO.OrderResponseDTO;
import com.example.sample.Entity.Orders;
import org.mapstruct.*;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.name", target = "userName")
    OrderResponseDTO toDTO(Orders orders);

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "user", ignore = true)
    Orders toEntity(OrderRegisterDTO orderRegisterDTO);

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "user", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromRequest(OrderRegisterDTO registerDTO, @MappingTarget Orders orders);

}
