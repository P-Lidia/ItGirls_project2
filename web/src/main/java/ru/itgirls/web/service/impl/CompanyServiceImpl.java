package ru.itgirls.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.itgirls.web.dto.company.CompanyCreateDto;
import ru.itgirls.web.dto.company.CompanyDto;
import ru.itgirls.web.dto.company.CompanyUpdateDto;
import ru.itgirls.web.feignclients.CompanyFeignClient;
import ru.itgirls.web.service.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyFeignClient companyFeignClient;

    @Autowired
    public CompanyServiceImpl(CompanyFeignClient companyFeignClient) {
        this.companyFeignClient = companyFeignClient;
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        return companyFeignClient.getAllCompanies();
    }

    @Override
    public CompanyDto getCompanyById(Long id) {
        return companyFeignClient.getCompanyById(id);
    }

    @Override
    public CompanyDto getCompanyByName(String name) {
        return companyFeignClient.getCompanyByName(name);
    }

    @Override
    public CompanyDto createCompany(CompanyCreateDto companyCreateDto) {
        return companyFeignClient.createCompany(companyCreateDto);
    }

    @Override
    public CompanyDto updateCompany(CompanyUpdateDto companyUpdateDto) {
        return companyFeignClient.updateCompany(companyUpdateDto);
    }

    @Override
    public void deleteCompany(Long id) {
        companytFeignClient.deleteCompany(id);
    }
}