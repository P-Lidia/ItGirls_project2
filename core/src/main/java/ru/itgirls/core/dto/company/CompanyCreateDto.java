package ru.itgirls.core.dto.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itgirls.core.dto.product.ProductDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompanyCreateDto {
    private String name;
    private ProductDto productDto;
}
