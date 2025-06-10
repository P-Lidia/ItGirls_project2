package ru.itgirls.web.service;

import org.springframework.http.ResponseEntity;
import ru.itgirls.web.dto.user.UserCreateDto;

public interface RegistrationService {
    ResponseEntity<String> register(UserCreateDto userCreateDto);

    void activate(String activationKey);
}
