package ru.itgirls.web.feignclients;

import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.itgirls.web.dto.product.ProductCreateDto;
import ru.itgirls.web.dto.product.ProductDto;
import ru.itgirls.web.dto.product.ProductUpdateDto;

import java.util.List;

@FeignClient(name = "product-core", url = "${feign.client.user-core.url}")
public interface ProductFeignClient {

    @GetMapping("/api/products/all")
    List<ProductDto> getAllProducts();

    @GetMapping("/api/products/id/{id}")
    ProductDto getProductById(@PathVariable("id") Long id);

    @GetMapping("/api/products/name/{name}")
    ProductDto getProductByName(@PathVariable("name") String name);

    @PostMapping("/api/products/create")
    ProductDto createProduct(@RequestBody @Valid ProductCreateDto productCreateDto);

    @PutMapping("/api/products/update")
    ProductDto updateProduct(@RequestBody @Valid ProductUpdateDto productUpdateDto);

    @DeleteMapping("/api/products/delete/{id}")
    void deleteProduct(@PathVariable("id") Long id);
}
