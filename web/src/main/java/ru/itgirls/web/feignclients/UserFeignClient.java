package ru.itgirls.web.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itgirls.web.dto.user.UserCreateDto;

@FeignClient(name = "user_core", url = "${feign.client.user_core.url}")
@RequestMapping("/api")
public interface UserFeignClient {

    @PostMapping("/register")
    ResponseEntity<String> registerUser(@RequestBody UserCreateDto userCreateDto);

    @PostMapping("/activate")
    void activateUser(@RequestBody String activationKey);
}