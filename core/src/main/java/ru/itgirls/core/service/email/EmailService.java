package ru.itgirls.core.service.email;

import ru.itgirls.core.dto.user.UserRegistrationDto;

public interface EmailService {

    void register(UserRegistrationDto userRegistrationDto);

    void activate(String activationKey);

}