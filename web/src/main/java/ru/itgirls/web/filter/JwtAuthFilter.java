package ru.itgirls.web.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final JwtTokenManager jwtTokenManager;
    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            if (token.isBlank() || !jwtTokenManager.isNotBlacklisted(token)) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                        "Token is not valid");
                return;
            }
            try {
                DecodedJWT jwt = jwtUtil.verifyToken(token);
                Long userId = jwt.getClaim("userId").asLong();
                UserDetails userDetails = userDetailsService.loadUserById(userId);
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                userDetails.getPassword(),
                                userDetails.getAuthorities()
                        );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } catch (JWTVerificationException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                        "Token is not valid");
            }
        }
        filterChain.doFilter(request, response);
    }
}
