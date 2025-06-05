package ru.itgirls.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itgirls.core.dto.user.UserActivationDto;
import ru.itgirls.core.dto.user.UserRegistrationDto;
import ru.itgirls.core.repository.UserRepository;
import ru.itgirls.core.service.UserService;
import ru.itgirls.core.service.email.EmailService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RegistrationController {

    private final EmailService emailService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        return userService.registerUser(userRegistrationDto);
    }

    @PostMapping("/activate")
    public void activateUser(@RequestBody UserActivationDto userActivationDto, String activationKey) {
        emailService.activate(userActivationDto, activationKey);
    }
}
