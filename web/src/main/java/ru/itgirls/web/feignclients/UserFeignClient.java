package ru.itgirls.web.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itgirls.web.dto.user.AuthRequestDto;
import ru.itgirls.web.dto.user.JwtUserDto;
import ru.itgirls.web.dto.user.UserCreateDto;

@FeignClient(name = "auth-core", url = "${feign.client.user-core.url}")
public interface UserFeignClient {

    @PostMapping("/api/auth/register")
    ResponseEntity<String> registerUser(@RequestBody UserCreateDto userCreateDto);

    @PostMapping("/api/auth/activate")
    void activateUser(@RequestBody String activationKey);

    @PostMapping("/api/auth/login")
    JwtUserDto validateUser(@RequestBody AuthRequestDto request);
}