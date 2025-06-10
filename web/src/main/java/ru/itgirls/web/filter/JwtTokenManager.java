package ru.itgirls.web.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenManager {

//    private final Set<String> blackList;
//    private final JwtUtil jwtUtil;
//
//    public void addToBlackList(String token) {
//        blackList.add(token);
//        log.info("Token added to the blackList");
//    }
//
//    public boolean isNotBlacklisted(String token) {
//        return !blackList.contains(token);
//    }
}