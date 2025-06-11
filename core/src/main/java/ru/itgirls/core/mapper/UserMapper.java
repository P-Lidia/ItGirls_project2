package ru.itgirls.core.mapper;

import org.mapstruct.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itgirls.core.dto.user.UserCreateDto;
import ru.itgirls.core.dto.user.UserRegistrationDto;
import ru.itgirls.core.entity.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Mapping(target = "password", expression = "java(encodePassword(userCreateDto.getPassword()))")
    @Mapping(target = "isEnable", constant = "false")
    User toEntity(UserCreateDto userCreateDto, @Context PasswordEncoder passwordEncoder);

    UserRegistrationDto toDto (User user);
}