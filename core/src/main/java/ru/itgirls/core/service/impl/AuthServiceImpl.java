package ru.itgirls.core.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itgirls.core.dto.user.AuthRequestDto;
import ru.itgirls.core.dto.user.JwtUserDto;
import ru.itgirls.core.dto.user.UserCreateDto;
import ru.itgirls.core.dto.user.UserRegistrationDto;
import ru.itgirls.core.entity.User;
import ru.itgirls.core.mapper.UserMapper;
import ru.itgirls.core.repository.UserRepository;
import ru.itgirls.core.service.AuthService;
import ru.itgirls.core.service.email.EmailService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public ResponseEntity<String> registerUser(UserCreateDto userCreateDto) {
        if (userRepository.findByEmail(userCreateDto.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User with this email already exists");
        }
        User createdUser = userMapper.toEntity(userCreateDto, passwordEncoder);
        UserRegistrationDto registrationDto = userMapper.toUserRegistrationDto(userRepository.save(createdUser));
        emailService.register(registrationDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User is successfully registered");
    }

    public JwtUserDto validateUser(AuthRequestDto authRequestDto) {
        User user = userRepository.findByEmail(authRequestDto.getEmail())
                .orElseThrow(() -> new EntityNotFoundException(
                        "User with email %s not found.".formatted(authRequestDto.getEmail())
                ));
        if (!passwordEncoder.matches(authRequestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid password for user %s".formatted(authRequestDto.getEmail()));
        }
        return userMapper.toJwtUserDto(user);
    }
}