package ru.itgirls.core.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itgirls.core.dto.company.CompanyDto;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductCreateDto {
        private String name;
        private BigDecimal price;
        private CompanyDto companyDto;
}
