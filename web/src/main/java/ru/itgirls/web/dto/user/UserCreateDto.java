package ru.itgirls.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itgirls.web.model.Role;

@Data
@AllArgsConstructor
public class UserCreateDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Role role;
}