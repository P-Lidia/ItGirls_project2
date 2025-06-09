package ru.itgirls.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirls.core.entity.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
}
