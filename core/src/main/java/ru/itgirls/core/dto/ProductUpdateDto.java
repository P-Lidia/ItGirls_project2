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

public class ProductUpdateDto {
    @Size(min = 2)
    @NotBlank(message = "Необходимо указать название товара")
    private String name;
    @Size(min = 1)
    @NotNull(message = "Необходимо указать цену товара")
    private Float price;
    @NotNull(message = "Необходимо указать компанию-производителя")
    private String company;
}
