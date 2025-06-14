package ru.itgirls.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCreateDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;
}