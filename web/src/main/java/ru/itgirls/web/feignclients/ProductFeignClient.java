package ru.itgirls.web.feignclients;

import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.itgirls.web.dto.product.ProductCreateDto;
import ru.itgirls.web.dto.product.ProductDto;
import ru.itgirls.web.dto.product.ProductUpdateDto;

import java.util.List;

@FeignClient(name = "product_core", url = "https://localhost:8081")
@RequestMapping("/product")
public interface ProductFeignClient {

    @GetMapping("/all")
    List<ProductDto> getAllProducts();

    @GetMapping("/id/{id}")
    ProductDto getProductById(@PathVariable("id") Long id);

    @GetMapping("/name/{name}")
    ProductDto getProductByName(@PathVariable("name") String name);

    @PostMapping("/create")
    ProductDto createProduct(@RequestBody @Valid ProductCreateDto productCreateDto);

    @PutMapping("/update")
    ProductDto updateProduct(@RequestBody @Valid ProductUpdateDto productUpdateDto);

    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable("id") Long id);
}
