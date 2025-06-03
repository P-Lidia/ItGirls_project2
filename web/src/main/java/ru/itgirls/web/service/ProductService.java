package ru.itgirls.core.service;

public interface ProductService {

    public ProductDto createProduct(ProductDto productDto);
    public ProductDto updateProduct(ProductDto productDto);
    public ProductDto deleteProduct(ProductDto productDto);
}
