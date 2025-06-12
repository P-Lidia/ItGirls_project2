package ru.itgirls.web.service;

import ru.itgirls.web.dto.company.CompanyDto;
import ru.itgirls.web.dto.company.CompanyCreateDto;
import ru.itgirls.web.dto.company.CompanyUpdateDto;

import java.util.List;

public class CompanyService {
    CompanyDto createCompany(CompanyCreateDto companyCreateDto);

    CompanyDto getCompanyById(Long id);

    CompanyDto getCompanyByName(String name);

    List<CompanyDto> getAllCompanies();

    CompanyDto updateCompany(CompanyUpdateDto companyUpdateDto);

    void deleteCompany(Long id);
}
