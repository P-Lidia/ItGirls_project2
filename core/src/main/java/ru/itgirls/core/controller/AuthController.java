package ru.itgirls.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirls.core.dto.user.AuthRequestDto;
import ru.itgirls.core.dto.user.JwtUserDto;
import ru.itgirls.core.dto.user.UserCreateDto;
import ru.itgirls.core.service.AuthService;
import ru.itgirls.core.service.email.EmailService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final EmailService emailService;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserCreateDto userCreateDto) {
        return authService.registerUser(userCreateDto);
    }

    @PostMapping("/activate")
    public ResponseEntity<String> activateUser(@RequestBody String activationKey) {
        return emailService.activate(activationKey);
    }

    @PostMapping("/login")
    public JwtUserDto authUser(@RequestBody AuthRequestDto authRequestDto) {
        return authService.validateUser(authRequestDto);
    }
}