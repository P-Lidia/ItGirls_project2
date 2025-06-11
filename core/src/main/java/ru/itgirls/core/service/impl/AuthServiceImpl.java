package ru.itgirls.core.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itgirls.core.dto.user.AuthUserDto;
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
        UserRegistrationDto registrationDto = userMapper.toDto(userRepository.save(createdUser));
        emailService.register(registrationDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User is successfully registered");
    }

    public boolean validateUser(AuthUserDto authUserDto) {
        User user = userRepository.findByEmail(authUserDto.getEmail())
                .orElseThrow(() -> new EntityNotFoundException(
                        "User with email %s not found.".formatted(authUserDto.getEmail())
                ));
        return passwordEncoder.matches(authUserDto.getPassword(), user.getPassword());
    }
}
