package ru.itgirls.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itgirls.core.dto.user.UserCreateDto;
import ru.itgirls.core.dto.user.UserRegistrationDto;
import ru.itgirls.core.entity.User;
import ru.itgirls.core.entity.UserRole;
import ru.itgirls.core.mapper.UserRegistrationMapper;
import ru.itgirls.core.repository.UserRepository;
import ru.itgirls.core.service.UserService;
import ru.itgirls.core.service.email.EmailService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final UserRegistrationMapper mapper;

    @Transactional
    @Override
    public ResponseEntity<String> registerUser(UserCreateDto userCreateDto) {
        if (userRepository.findByEmail(userCreateDto.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User with this email already exists");
        }
        User createdUser = mapper.toEntity(userCreateDto, passwordEncoder);
        userRepository.save(createdUser);
        UserRegistrationDto registrationDto = mapper.toDto(createdUser);
        emailService.register(registrationDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User is successfully registered");
    }
}
