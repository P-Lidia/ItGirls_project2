package ru.itgirls.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itgirls.web.model.Role;

@Data
@Builder
@AllArgsConstructor
public class UserCreateDto {
    private String name;
    private String surname;
    private String email;
    private String password1;
    private String password2;
    private Role role;
}