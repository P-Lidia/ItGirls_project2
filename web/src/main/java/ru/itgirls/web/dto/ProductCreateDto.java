package ru.itgirls.web.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductCreateDto {
        @Size(min = 2)
        @NotBlank(message = "Please enter the product name")
        private String name;
        @DecimalMin(value = "0.01", inclusive = true)
        @NotNull(message = "Please enter the product price")
        private BigDecimal price;
        @NotBlank(message = "Please enter the product producer")
        private String company;
}
