package ru.itgirls.web.feignclients;

import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.itgirls.web.dto.company.CompanyCreateDto;
import ru.itgirls.web.dto.company.CompanyDto;
import ru.itgirls.web.dto.company.CompanyUpdateDto;

import java.util.List;

@FeignClient(name = "company_core", url = "${feign.client.user_core.url}")
@RequestMapping("/api/company")
public interface CompanyFeignClient {

    @GetMapping("/all")
    List<CompanyDto> getAllCompanies();

    @GetMapping("/id/{id}")
    CompanyDto getCompanyById(@PathVariable("id") Long id);

    @GetMapping("/name/{name}")
    CompanyDto getCompanyByName(@PathVariable("name") String name);

    @PostMapping("/create")
    CompanyDto createCompany(@RequestBody @Valid CompanyCreateDto companyCreateDto);

    @PutMapping("/update")
    CompanyDto updateCompany(@RequestBody @Valid CompanyUpdateDto companyUpdateDto);

    @DeleteMapping("/delete/{id}")
    void deleteCompany(@PathVariable("id") Long id);
}
