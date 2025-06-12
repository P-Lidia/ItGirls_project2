package ru.itgirls.web.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.itgirls.web.model.RoleType;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    public static final String BEARER_PREFIX = "Bearer ";
    public static final String HEADER_NAME = "Authorization";
    private final JwtTokenManager jwtTokenManager;
    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        final String header = request.getHeader(HEADER_NAME);
        if (header == null || !header.startsWith(BEARER_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }
        final String token = header.substring(BEARER_PREFIX.length());
        if (token.isBlank() || jwtTokenManager.isNotBlacklisted(token)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Token is invalid or blacklisted");
        }
        DecodedJWT jwt = jwtUtil.verifyToken(token);
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        Long userId = jwt.getClaim("userId").asLong();
        RoleType userRole = RoleType.valueOf(jwt.getClaim("role").asString());
        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(userId, userRole);
        context.setAuthentication(authentication);
    }
}
