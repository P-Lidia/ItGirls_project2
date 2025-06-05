package ru.itgirls.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itgirls.core.dto.user.UserRegistrationDto;
import ru.itgirls.core.entity.User;
import ru.itgirls.core.entity.UserRole;
import ru.itgirls.core.repository.UserRepository;
import ru.itgirls.core.service.UserService;
import ru.itgirls.core.service.email.EmailService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<String> registerUser(UserRegistrationDto userRegistrationDto) {
        if (userRepository.findByEmail(userRegistrationDto.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User with this email already exists");

        }
        User newUser = new User();
        newUser.setName(userRegistrationDto.getName());
        newUser.setEmail(userRegistrationDto.getEmail());
        newUser.setSurname(userRegistrationDto.getSurname());
        newUser.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        newUser.setRole(UserRole.ROLE_CUSTOMER);
        emailService.register(userRegistrationDto);
        userRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User is successfully registered");
    }
}
