package ru.itgirls.core.service;

import ru.itgirls.core.dto.product.ProductCreateDto;
import ru.itgirls.core.dto.product.ProductDto;
import ru.itgirls.core.dto.product.ProductUpdateDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductCreateDto productCreateDto);

    ProductDto updateProduct(ProductUpdateDto productUpdateDto);

    void deleteProduct(Long id);

    ProductDto findById(Long id);

    ProductDto findByName(String name);

    List<ProductDto> getAllProducts();

}
