package ru.itgirls.web.service;

import ru.itgirls.web.dto.company.CompanyCreateDto;
import ru.itgirls.web.dto.company.CompanyDto;
import ru.itgirls.web.dto.company.CompanyUpdateDto;

import java.util.List;

public interface CompanyService {

    List<CompanyDto> getAllCompanies();

    CompanyDto getCompanyById(Long id);

    CompanyDto getCompanyByName(String name);

    CompanyDto createCompany(CompanyCreateDto companyCreateDto);

    CompanyDto updateCompany(CompanyUpdateDto companyUpdateDto);

    void deleteCompany(Long id);
}
