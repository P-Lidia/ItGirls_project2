package ru.itgirls.web.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirls.web.dto.company.CompanyCreateDto;
import ru.itgirls.web.dto.company.CompanyDto;
import ru.itgirls.web.dto.company.CompanyUpdateDto;
import ru.itgirls.web.feignclients.CompanyFeignClient;
import ru.itgirls.web.service.CompanyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyFeignClient companyFeignClient;

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
    public CompanyDto createCompany(CompanyCreateDto dto) {
        return companyFeignClient.createCompany(dto);
    }

    @Override
    public CompanyDto updateCompany(CompanyUpdateDto dto) {
        return companyFeignClient.updateCompany(dto);
    }

    @Override
    public void deleteCompany(Long id) {
        companyFeignClient.deleteCompany(id);
    }
}
