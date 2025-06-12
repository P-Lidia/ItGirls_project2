package ru.itgirls.core.service;

import ru.itgirls.core.dto.company.CompanyDto;
import ru.itgirls.core.dto.company.CompanyCreateDto;
import ru.itgirls.core.dto.company.CompanyUpdateDto;

import java.util.List;

public interface CompanyService {
    CompanyDto createCompany(CompanyCreateDto companyCreateDto);

    CompanyDto getCompanyById(Long id);

    CompanyDto getCompanyByName(String name);

    List<CompanyDto> getAllCompanies();

    CompanyDto updateCompany(CompanyUpdateDto companyUpdateDto);

    void deleteCompany(Long id);
}
