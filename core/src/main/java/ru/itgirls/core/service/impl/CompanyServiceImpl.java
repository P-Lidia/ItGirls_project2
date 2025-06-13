package ru.itgirls.core.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirls.core.dto.company.CompanyCreateDto;
import ru.itgirls.core.dto.company.CompanyDto;
import ru.itgirls.core.dto.company.CompanyUpdateDto;
import ru.itgirls.core.entity.Company;
import ru.itgirls.core.entity.Product;
import ru.itgirls.core.mapper.CompanyMapper;
import ru.itgirls.core.mapper.ProductMapper;
import ru.itgirls.core.repository.CompanyRepository;
import ru.itgirls.core.service.CompanyService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final ProductMapper productMapper;

    @Override
    public CompanyDto getCompanyById(Long id) {
        return companyMapper.companyToDto(findCompanyById(id));
    }

    @Override
    public CompanyDto getCompanyByName(String name) {
        Company company = companyRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Company not found."));
        return companyMapper.companyToDto(company);
    }

    @Override
    public CompanyDto createCompany(CompanyCreateDto companyCreateDto) {
        Company company = companyRepository.save(companyMapper.companyDtoToEntity(companyCreateDto));
        return companyMapper.companyToDto(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> company = companyRepository.findAll();
        return company.stream()
                .map(companyMapper::companyToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDto updateCompany(CompanyUpdateDto companyUpdateDto) {
        Company company = findCompanyById(companyUpdateDto.getId());
        company.setName(companyUpdateDto.getName());
        if (companyUpdateDto.getProductDto() != null) {
            Product product = productMapper.dtoToEntity(companyUpdateDto.getProductDto());
            company.getProducts().add(product);
        }
        companyRepository.save(company);
        return companyMapper.companyToDto(company);
    }

    private Company findCompanyById(long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found."));
    }
}
