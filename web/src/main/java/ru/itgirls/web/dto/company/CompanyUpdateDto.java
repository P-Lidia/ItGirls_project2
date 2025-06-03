package ru.itgirls.web.dto.company;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itgirls.web.dto.product.ProductDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompanyUpdateDto {
    private Long id;
    @Size(min = 2)
    @NotBlank(message = "Please enter the company name")
    private String name;
    @NotNull(message = "Please enter the produced product")
    @Valid
    private ProductDto productDto;
}
