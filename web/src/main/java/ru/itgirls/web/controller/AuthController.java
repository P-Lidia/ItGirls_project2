package ru.itgirls.web.controller;

import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirls.web.dto.user.AuthRequestDto;
import ru.itgirls.web.dto.user.AuthResponseDto;
import ru.itgirls.web.dto.user.RegistrationRequestDto;
import ru.itgirls.web.mapper.UserMapper;
import ru.itgirls.web.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final UserMapper userMapper;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegistrationRequestDto request) {
        return authService.register(userMapper.toUserCreateDto(request));
    }

    @GetMapping("/activate")
    public ResponseEntity<String> activate(@RequestParam @NonNull String key) {
        return authService.activate(key);
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody @Valid AuthRequestDto request) {
        return authService.login(request);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String authHeader) {
        authService.logout(authHeader);
        return ResponseEntity
                .ok()
                .build();
    }
}