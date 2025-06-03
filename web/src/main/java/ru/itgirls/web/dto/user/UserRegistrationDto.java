package ru.itgirls.web.dto.user;

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
}
