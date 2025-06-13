package ru.itgirls.web.service;

import ru.itgirls.web.dto.user.AuthRequestDto;
import ru.itgirls.web.dto.user.AuthResponseDto;

public interface AuthService {
    AuthResponseDto login(AuthRequestDto request);

    void logout(String token);
}
