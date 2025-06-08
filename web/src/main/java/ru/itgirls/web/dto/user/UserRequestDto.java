package ru.itgirls.web.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itgirls.web.validation.PasswordMatches;

@Data
@Builder
@AllArgsConstructor
@PasswordMatches
public class UserRequestDto {

    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotBlank(message = "Surname must not be blank")
    private String surname;

    @NotBlank(message = "Email must not be blank")
    private String email;

    @NotBlank(message = "Password must not be blank")
    @Size(max = 255, message = "Password must be no longer than 255 characters")
    private String password;

    @NotBlank(message = "Password must not be blank")
    @Size(max = 255, message = "Password must be no longer than 255 characters")
    private String confirmPassword;

    @NotNull(message = "User role must not be null")
    private UserRole userRole;
}
