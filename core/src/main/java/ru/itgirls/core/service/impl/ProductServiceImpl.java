package ru.itgirls.core.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirls.core.dto.product.ProductCreateDto;
import ru.itgirls.core.dto.product.ProductDto;
import ru.itgirls.core.dto.product.ProductUpdateDto;
import ru.itgirls.core.entity.Product;
import ru.itgirls.core.mapper.ProductMapper;
import ru.itgirls.core.repository.ProductRepository;
import ru.itgirls.core.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto findById(Long id) {
        return productMapper.productToDto(findProductById(id));
    }

    @Override
    public ProductDto findByName(String name) {
        Product product = productRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Product not found."));
        return productMapper.productToDto(product);
    }

    @Override
    public ProductDto createProduct(ProductCreateDto productCreateDto) {
        Product product = productRepository.save(productMapper.productDtoToEntity(productCreateDto));
        return productMapper.productToDto(product);
    }

    @Override
    public ProductDto updateProduct(ProductUpdateDto productUpdateDto) {
        Product product = findProductById(productUpdateDto.getId());
        product.setName(productUpdateDto.getName());
        product.setPrice(productUpdateDto.getPrice());
        product.setCompany(productUpdateDto.getCompany());
        Product savedProduct = productRepository.save(product);
        return productMapper.productToDto(savedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::productToDto)
                .collect(Collectors.toList());
    }

    private Product findProductById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found."));
    }
}
