package ru.itgirls.core.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserRegistrationDto {
    private Long id;
    private String name;
    private String email;
    private String surname;
    private String password;
}
