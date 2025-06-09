package ru.itgirls.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itgirls.core.dto.ProductCreateDto;
import ru.itgirls.core.dto.ProductDto;
import ru.itgirls.core.dto.ProductUpdateDto;
import ru.itgirls.web.feignclients.ProductFeignClient;
import ru.itgirls.web.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductFeignClient productFeignClient;

    @Autowired
    public ProductServiceImpl(ProductFeignClient productFeignClient) {
        this.productFeignClient = productFeignClient;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productFeignClient.getProductById(id);
    }

    @Override
    public ProductDto getProductByName(String name) {
        return productFeignClient.getProductByName(name);
    }

    @Override
    public ProductDto createProduct(ProductCreateDto productCreateDto) {
        return productFeignClient.createProduct(productCreateDto);
    }

    @Override
    public ProductDto updateProduct(ProductUpdateDto productUpdateDto) {
        return productFeignClient.updateProduct(productUpdateDto);
    }

    @Override
    public void deleteProduct(Long id) {
        productFeignClient.deleteProduct(id);;
    }
}