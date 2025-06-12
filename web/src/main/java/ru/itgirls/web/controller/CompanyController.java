package ru.itgirls.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirls.web.dto.company.CompanyCreateDto;
import ru.itgirls.web.dto.company.CompanyDto;
import ru.itgirls.web.dto.company.CompanyUpdateDto;
import ru.itgirls.web.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyDto createCompany(@Valid @RequestBody CompanyCreateDto companyCreateDto) {
        return companyService.createCompany(companyCreateDto);
    }

    @GetMapping("/{id}")
    public CompanyDto getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping("/by-name/{name}")
    public CompanyDto getCompanyByName(@PathVariable String name) {
        return companyService.getCompanyByName(name);
    }

    @GetMapping("/all-companies")
    public List<CompanyDto> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PutMapping("/update")
    public CompanyDto updateCompany(@RequestBody @Valid CompanyUpdateDto companyUpdateDto) {
        return companyService.updateCompany(companyUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }
}
