package ru.itgirls.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirls.core.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
