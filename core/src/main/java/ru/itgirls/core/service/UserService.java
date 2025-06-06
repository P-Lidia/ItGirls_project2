package ru.itgirls.core.service;

import org.springframework.http.ResponseEntity;
import ru.itgirls.core.dto.user.UserRegistrationDto;

public interface UserService {

    ResponseEntity<String> registerUser(UserRegistrationDto userRegistrationDto);

}
