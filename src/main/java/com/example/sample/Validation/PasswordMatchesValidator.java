package com.example.sample.Validation;

import com.example.sample.DTO.UserRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserRequestDTO> {

    @Override
    public boolean isValid(UserRequestDTO dto, ConstraintValidatorContext context) {
        if (dto.getPassword() == null || dto.getConfirmPassword() == null) {
            return false;
    }
    return dto.getPassword().equals(dto.getConfirmPassword());
    }

}
