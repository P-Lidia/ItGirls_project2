package ru.itgirls.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompanyUpdateDto {
    @Size(min = 2)
    @NotBlank(message = "Необходимо указать название компании")
    private String name;
    @NotNull(message = "Необходимо указать произведённый товар")
    private ProductDto productDto;
}
