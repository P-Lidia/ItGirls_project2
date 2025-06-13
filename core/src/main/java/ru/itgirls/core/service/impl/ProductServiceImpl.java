package ru.itgirls.core.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itgirls.core.dto.product.ProductCreateDto;
import ru.itgirls.core.dto.product.ProductDto;
import ru.itgirls.core.dto.product.ProductUpdateDto;
import ru.itgirls.core.entity.Company;
import ru.itgirls.core.entity.Product;
import ru.itgirls.core.mapper.ProductMapper;
import ru.itgirls.core.repository.CompanyRepository;
import ru.itgirls.core.repository.ProductRepository;
import ru.itgirls.core.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CompanyRepository companyRepository;

    @Override
    public ProductDto getProductById(Long id) {
        return productMapper.productToDto(findProductById(id));
    }

    @Override
    public ProductDto getProductByName(String name) {
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
    @Transactional
    public ProductDto updateProduct(ProductUpdateDto productUpdateDto) {
        Product product = findProductById(productUpdateDto.getId());
        product.setName(productUpdateDto.getName());
        product.setPrice(productUpdateDto.getPrice());
        if (productUpdateDto.getCompanyDto() != null) {
            Company company = companyRepository.findById(productUpdateDto.getCompanyDto().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Company not found."));
            product.setCompany(company);
            company.getProducts().add(product);
        }
        productRepository.save(product);
        return productMapper.productToDto(product);
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

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found."));
    }
}