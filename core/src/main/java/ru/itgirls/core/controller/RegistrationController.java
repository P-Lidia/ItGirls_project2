package ru.itgirls.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirls.core.dto.user.UserCreateDto;
import ru.itgirls.core.service.UserService;
import ru.itgirls.core.service.email.EmailService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RegistrationController {

    private final EmailService emailService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserCreateDto userCreateDto) {
        return userService.registerUser(userCreateDto);
    }

    @PostMapping("/activate")
    public void activateUser(@RequestBody String activationKey) {
        emailService.activate(activationKey);
    }
}
