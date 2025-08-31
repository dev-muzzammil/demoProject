package com.example.sample.Service;

import com.example.sample.DTO.UserRequestDTO;
import com.example.sample.DTO.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponseDTO registerUser(UserRequestDTO requestDTO);

    UserResponseDTO getById(Long id);

    Page<UserResponseDTO> getAllUsers(Pageable pageable);

    UserResponseDTO update(Long id, UserRequestDTO requestDTO);

    void delete(Long id);

}
