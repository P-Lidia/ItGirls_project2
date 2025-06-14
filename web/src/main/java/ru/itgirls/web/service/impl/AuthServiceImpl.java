package ru.itgirls.web.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.itgirls.web.dto.user.AuthRequestDto;
import ru.itgirls.web.dto.user.AuthResponseDto;
import ru.itgirls.web.dto.user.JwtUserDto;
import ru.itgirls.web.dto.user.UserCreateDto;
import ru.itgirls.web.feignclients.AuthFeignClient;
import ru.itgirls.web.filter.JwtTokenManager;
import ru.itgirls.web.filter.JwtUtil;
import ru.itgirls.web.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthFeignClient authFeignClient;
    private final JwtTokenManager jwtTokenManager;
    private final JwtUtil jwtUtil;

    @Override
    public ResponseEntity<String> register(UserCreateDto userCreateDto) {
        return authFeignClient.registerUser(userCreateDto);
    }

    @Override
    public ResponseEntity<String> activate(String activationKey) {
        return authFeignClient.activateUser(activationKey);
    }

    @Override
    public AuthResponseDto login(AuthRequestDto request) {
        JwtUserDto jwtUserDto = authFeignClient.validateUser(request);
        String token = jwtUtil.generateToken(jwtUserDto);
        return new AuthResponseDto(token);
    }

    @Override
    public void logout(String authHeader) {
        jwtTokenManager.addToBlackList(authHeader);
    }
}