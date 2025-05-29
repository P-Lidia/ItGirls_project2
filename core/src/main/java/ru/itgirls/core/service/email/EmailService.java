package ru.itgirls.core.service.email;

import ru.itgirls.core.dto.UserActivationDto;
import ru.itgirls.core.dto.UserRegistrationDto;

public interface EmailService {

    void register(UserRegistrationDto userRegistrationDto);

    void activation(UserActivationDto userActivationDto, String activationKey);

}
