package ru.itgirls.web.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.itgirls.web.dto.user.JwtUserDto;

import java.util.Date;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtil {

    private static final String ISSUER = "itGirls project app";
    private static final String SUBJECT = "user details";
    private static final String CLAIM_USER_ID = "userId";
    private static final String CLAIM_ROLE = "role";
    private static final long EXPIRATION_TIME_MS = 60 * 60 * 1000;

    private final Set<String> blackList;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(JwtUserDto user) {
        return JWT.create()
                .withSubject(SUBJECT)
                .withClaim(CLAIM_USER_ID, user.getId())
                .withClaim(CLAIM_ROLE, user.getRole().name())
                .withIssuer(ISSUER)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME_MS))
                .sign(Algorithm.HMAC256(secret));
    }

    public DecodedJWT verifyToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject(SUBJECT)
                .withIssuer(ISSUER)
                .build();
        return verifier.verify(token);
    }

    public void addToBlackList(String token) {
        blackList.add(token);
        log.info("Token added to the blackList");
    }

    public boolean isNotBlacklisted(String token) {
        return !blackList.contains(token);
    }
}