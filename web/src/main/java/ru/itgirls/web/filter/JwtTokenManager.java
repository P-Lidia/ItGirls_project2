package ru.itgirls.web.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenManager {

    private final Set<String> blackList;
    private final JwtUtil jwtUtil;

    public ResponseEntity<String> addToBlackList(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("Invalid Authorization header");
        }
        String token = authHeader.substring(7);
        blackList.add(token);
        log.info("Token added to the blackList");
        return ResponseEntity.ok("Token added to the blacklist");
    }

    public boolean isNotBlacklisted(String token) {
        return !blackList.contains(token);
    }
}