package ru.itgirls.web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.itgirls.web.dto.user.RegistrationRequestDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RegistrationRequestDto> {

    @Override
    public boolean isValid(RegistrationRequestDto requestDto, ConstraintValidatorContext context) {
        if (requestDto == null) {
            return false;
        }
        return requestDto.getPassword() != null
                && requestDto.getPassword().equals(requestDto.getConfirmPassword());
    }
}