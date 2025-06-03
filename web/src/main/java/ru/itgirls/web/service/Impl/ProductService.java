package ru.itgirls.web.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService implements ProductService{
    @Autowired
    private final ProductFeignClient productFeignClient;

    public ProductService(ProductFeignClient productFeignClient) {
        this.productFeignClient = productFeignClient;
    }

    public ProductDto createProduct(ProductDto productDto) {
        return productFeignClient.createProduct(productDto);
    }

    public ProductDto getProductById(Long id) {
        return productFeignClient.getProductById(id);
    }

    public ProductDto updateProduct(ProductDto productDto) {
        return  productDto);
    }

    public void deleteProduct(Long id) {
        productFeignClient.deleteProduct(id);
    }

    public List<ProductDto> getAllProducts() {
        return productFeignClient.getAllProducts();
    }
}





