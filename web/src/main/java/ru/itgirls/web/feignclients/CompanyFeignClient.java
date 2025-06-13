package ru.itgirls.web.feignclients;

import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itgirls.web.dto.company.CompanyCreateDto;
import ru.itgirls.web.dto.company.CompanyDto;
import ru.itgirls.web.dto.company.CompanyUpdateDto;

import java.util.List;

@FeignClient(name = "company-core", url = "${feign.client.user-core.url}")
public interface CompanyFeignClient {

    @GetMapping("/api/companies/all")
    List<CompanyDto> getAllCompanies();

    @GetMapping("/api/companies/id/{id}")
    CompanyDto getCompanyById(@PathVariable("id") Long id);

    @GetMapping("/api/companies/name/{name}")
    CompanyDto getCompanyByName(@PathVariable("name") String name);

    @PostMapping("/api/companies/create")
    CompanyDto createCompany(@RequestBody @Valid CompanyCreateDto companyCreateDto);

    @PutMapping("/api/companies/update")
    CompanyDto updateCompany(@RequestBody @Valid CompanyUpdateDto companyUpdateDto);

    @DeleteMapping("/api/companies/delete/{id}")
    void deleteCompany(@PathVariable("id") Long id);
}
