package ru.itgirls.core.service;

import org.springframework.http.ResponseEntity;
import ru.itgirls.core.dto.user.AuthUserDto;
import ru.itgirls.core.dto.user.JwtUserDto;
import ru.itgirls.core.dto.user.UserCreateDto;

public interface AuthService {

    ResponseEntity<String> registerUser(UserCreateDto userCreateDto);

    JwtUserDto validateUser(AuthUserDto authUserDto);
}