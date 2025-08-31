package com.example.sample.Mapper;

import com.example.sample.DTO.UserRequestDTO;
import com.example.sample.DTO.UserResponseDTO;
import com.example.sample.Entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO toDto(User user);

    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDTO requestDTO);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromRequest(UserRequestDTO requestDTO, @MappingTarget User entity);

}
