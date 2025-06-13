package ru.itgirls.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itgirls.web.model.RoleType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtUserDto {
    private Long id;
    private RoleType role;
}