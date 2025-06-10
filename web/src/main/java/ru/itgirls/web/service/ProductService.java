package ru.itgirls.web.service;



import ru.itgirls.web.dto.product.ProductCreateDto;
import ru.itgirls.web.dto.product.ProductDto;
import ru.itgirls.web.dto.product.ProductUpdateDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    ProductDto getProductByName(String name);

    ProductDto createProduct(ProductCreateDto productCreateDto);

    ProductDto updateProduct(ProductUpdateDto productUpdateDto);

    void deleteProduct(Long id);
}
