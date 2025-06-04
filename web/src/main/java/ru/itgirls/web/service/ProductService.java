package ru.itgirls.web.service;

public interface ProductService {
    List<ProductDto> getAllProducts();

    ProductDto <ProductDto> getProductById(Long id);

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);
}
