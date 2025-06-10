package ru.itgirls.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtUser {
    private Long id;
    private String email;
    private String role;
}