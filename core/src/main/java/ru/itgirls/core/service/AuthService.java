package ru.itgirls.core.service;

import org.springframework.http.ResponseEntity;
import ru.itgirls.core.dto.user.AuthRequestDto;
import ru.itgirls.core.dto.user.JwtUserDto;
import ru.itgirls.core.dto.user.UserCreateDto;

public interface AuthService {

    ResponseEntity<String> registerUser(UserCreateDto userCreateDto);

    JwtUserDto validateUser(AuthRequestDto authRequestDto);
}