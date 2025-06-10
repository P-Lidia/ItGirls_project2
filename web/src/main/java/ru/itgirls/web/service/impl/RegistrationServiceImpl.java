package ru.itgirls.web.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.itgirls.web.dto.user.UserCreateDto;
import ru.itgirls.web.feignclients.UserFeignClient;
import ru.itgirls.web.service.RegistrationService;

@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserFeignClient userFeignClient;

    public ResponseEntity<String> register(UserCreateDto userCreateDto) {
        return userFeignClient.registerUser(userCreateDto);
    }

    public void activate(String activationKey) {
        userFeignClient.activateUser(activationKey);
    }
}