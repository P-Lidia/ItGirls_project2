package ru.itgirls.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirls.core.entity.Company;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByName(String name);
}