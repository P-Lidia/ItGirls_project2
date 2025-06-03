package ru.itgirls.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.itgirls.core.dto.product.ProductCreateDto;
import ru.itgirls.core.dto.product.ProductDto;
import ru.itgirls.core.entity.Product;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses=CompanyMapper.class)
public interface ProductMapper {

    ProductDto productToDto (Product product);

    Product dtoToEntity (ProductDto productDto);

    Product productDtoToEntity(ProductCreateDto productCreateDto);

}
