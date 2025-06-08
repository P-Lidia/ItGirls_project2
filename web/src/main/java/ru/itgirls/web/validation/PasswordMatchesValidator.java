package ru.itgirls.web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.itgirls.web.dto.user.UserRequestDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserRequestDto> {

    @Override
    public boolean isValid(UserRequestDto requestDto, ConstraintValidatorContext context) {
        if (requestDto == null) {
            return false;
        }
        return requestDto.getPassword() != null
                && requestDto.getPassword().equals(requestDto.getConfirmPassword());
    }
}