package ru.itgirls.web.service;

import org.springframework.http.ResponseEntity;
import ru.itgirls.web.dto.user.AuthRequestDto;
import ru.itgirls.web.dto.user.AuthResponseDto;
import ru.itgirls.web.dto.user.UserCreateDto;

public interface AuthService {

    ResponseEntity<String> register(UserCreateDto userCreateDto);

    ResponseEntity<String> activate(String activationKey);

    AuthResponseDto login(AuthRequestDto request);

    void logout(String authHeader);
}