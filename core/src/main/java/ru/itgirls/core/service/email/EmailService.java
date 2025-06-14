package ru.itgirls.core.service.email;

import org.springframework.http.ResponseEntity;
import ru.itgirls.core.dto.user.UserRegistrationDto;

public interface EmailService {

    void register(UserRegistrationDto userRegistrationDto);

    ResponseEntity<String> activate(String activationKey);

}