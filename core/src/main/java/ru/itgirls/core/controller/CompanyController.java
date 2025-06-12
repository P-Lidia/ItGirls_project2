package ru.itgirls.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itgirls.core.dto.company.CompanyCreateDto;
import ru.itgirls.core.dto.company.CompanyDto;
import ru.itgirls.core.dto.company.CompanyUpdateDto;
import ru.itgirls.core.service.CompanyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/all")
    public List<CompanyDto> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/id/{id}")
    public CompanyDto getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping("/name/{name}")
    public CompanyDto getCompanyByName(@PathVariable("name") String name) {
        return companyService.getCompanyByName(name);
    }

    @PostMapping("/create")
    public CompanyDto createCompany(@RequestBody CompanyCreateDto companyCreateDto) {
        return companyService.createCompany(companyCreateDto);
    }

    @PutMapping("/update")
    public CompanyDto updateCompany(@RequestBody CompanyUpdateDto companyUpdateDto) {
        return companyService.updateCompany(companyUpdateDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteCompany(id);
    }
}