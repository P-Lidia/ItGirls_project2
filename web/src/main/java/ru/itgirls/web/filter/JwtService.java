package ru.itgirls.web.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.itgirls.web.model.JwtUser;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class JwtService {

    private final Set<String> blackList;
    private final JwtUtil jwtUtil;

    public void addToBlackList(String token) {
        blackList.add(token);
    }

    public boolean isValid(String token) {
        return !blackList.contains(token);
    }

    public JwtUser getUserDetailsFromToken(String token) {
        DecodedJWT decodedJWT = jwtUtil.verifyToken(token);
        return new JwtUser(
                decodedJWT.getClaim("userId").asLong(),
                decodedJWT.getClaim("email").asString(),
                decodedJWT.getClaim("role").asString()
        );
    }
}
