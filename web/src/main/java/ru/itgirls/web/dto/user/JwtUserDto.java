package ru.itgirls.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itgirls.web.model.RoleType;

@Data
@AllArgsConstructor
public class JwtUserDto {
    private Long id;
    private RoleType role;
}