package ru.itgirls.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirls.core.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
