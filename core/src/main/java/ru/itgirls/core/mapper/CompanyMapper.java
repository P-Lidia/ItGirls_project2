package ru.itgirls.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.itgirls.core.dto.company.CompanyCreateDto;
import ru.itgirls.core.dto.company.CompanyDto;
import ru.itgirls.core.entity.Company;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses=ProductMapper.class)
public interface CompanyMapper {
    CompanyDto companyToDto (Company company);

    Company dtoToEntity (CompanyDto companyDto);

    Company companyDtoToEntity (CompanyCreateDto companyCreateDto);



}
