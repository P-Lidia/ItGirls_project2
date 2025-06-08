package ru.itgirls.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserCreateDto {

    private String name;
    private String surname;
    private String email;
    private String password;
    private UserRole userRole;
}