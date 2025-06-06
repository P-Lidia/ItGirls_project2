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

    public ProductDto getProductById(String name) {
        return productFeignClient.getProductByName(String name);
    }

    getProductByName() {
        return productFeignClient.getProductById(id);
    }
    public ProductDto updateProduct(ProductupdateDto productupdateDtoDto) {
        return productFeignClient.updateProduct(productupdateDtoDto);
    }

    public void deleteProduct(Long id) {
        productFeignClient.deleteProduct(id);
    }

    public List<ProductDto> getAllProducts() {
        return productFeignClient.getAllProducts();
    }
}