package ru.itgirls.core.service;

import org.springframework.http.ResponseEntity;
import ru.itgirls.core.dto.user.AuthUserDto;
import ru.itgirls.core.dto.user.UserCreateDto;
import ru.itgirls.core.dto.user.UserDetailsDto;

public interface AuthService {

    ResponseEntity<String> registerUser(UserCreateDto userCreateDto);

    boolean validateUser(AuthUserDto authUserDto);

    UserDetailsDto findUserById(Long id);
}