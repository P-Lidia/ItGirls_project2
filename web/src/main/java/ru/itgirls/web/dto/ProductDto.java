package ru.itgirls.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@DaTa
@builder

public class ProductDto {

    @NotBlank  @NotNull private Long id;

    @NotNull(message = "Product's name can't be null")
    @NotBlank(message = "Product's name can't be empty")
    private String name;

    @NotNull @NotBlank(message = "The price is necessary")
    private BigDecimal price;

    }
}