package ru.itgirls.web.service;

import ru.itgirls.core.dto.ProductCreateDto;
import ru.itgirls.core.dto.ProductDto;
import ru.itgirls.core.dto.ProductUpdateDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    ProductDto getProductByName(String name);

    ProductDto createProduct(ProductCreateDto productCreateDto);

    ProductDto updateProduct(ProductUpdateDto productUpdateDto);

    void deleteProduct(Long id);
}
