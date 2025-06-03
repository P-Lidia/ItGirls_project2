package ru.itgirls.web.dto;

import jakarta.validation.Valid;
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
public class CompanyCreateDto {
    @Size(min = 2)
    @NotBlank(message = "Please enter the company name")
    private String name;
    @NotNull(message = "Please enter the produced product")
    @Valid
    private ProductDto productDto;
}
