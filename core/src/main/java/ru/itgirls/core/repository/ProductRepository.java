package ru.itgirls.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirls.core.entity.Customer;
import ru.itgirls.core.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
