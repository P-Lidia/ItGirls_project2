package ru.itgirls.core.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itgirls.core.entity.UserRole;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    private String name;
    private String email;
    private String surname;
    private String password;
    private UserRole role;
}
