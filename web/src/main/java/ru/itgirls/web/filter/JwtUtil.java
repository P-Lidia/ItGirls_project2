package ru.itgirls.web.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.itgirls.web.model.JwtUser;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    @Value("${jwt.secret}")
    private final String secret;

    public String generateToken(JwtUser user) {
        return JWT.create()
                .withSubject("user details")
                .withClaim("userId", user.getId())
                .withClaim("email", user.getEmail())
                .withClaim("role", user.getRole())
                .withIssuer("itGirls project app")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .sign(Algorithm.HMAC256(secret));
    }

    public DecodedJWT verifyToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("user details")
                .withIssuer("itGirls project app")
                .build();
        return verifier.verify(token);
    }
}