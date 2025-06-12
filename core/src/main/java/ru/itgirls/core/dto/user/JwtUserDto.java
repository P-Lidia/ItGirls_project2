package ru.itgirls.core.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itgirls.core.entity.RoleType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtUserDto {
    private Long id;
    private RoleType role;
}
