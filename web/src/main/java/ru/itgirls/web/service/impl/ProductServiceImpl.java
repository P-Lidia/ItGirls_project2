package ru.itgirls.web.service.impl;

@Service

public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductFeignClient productFeignClient;

    public ProductServiceImpl(ProductFeignClient productFeignClient) {
        this.productFeignClient = productFeignClient;
    }

    public ProductDto createProduct(createProductDto createproductDto){
        return productFeignClient.createProduct(createProductDto);
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