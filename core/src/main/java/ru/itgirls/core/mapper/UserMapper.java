package ru.itgirls.core.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itgirls.core.dto.user.JwtUserDto;
import ru.itgirls.core.dto.user.UserCreateDto;
import ru.itgirls.core.dto.user.UserRegistrationDto;
import ru.itgirls.core.entity.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(userCreateDto.getPassword()))")
    @Mapping(target = "enable", constant = "false")
    User toEntity(UserCreateDto userCreateDto, @Context PasswordEncoder passwordEncoder);

    UserRegistrationDto toUserRegistrationDto(User user);

    @Mapping(target = "role", source = "role.roleType")
    JwtUserDto toJwtUserDto(User user);
}