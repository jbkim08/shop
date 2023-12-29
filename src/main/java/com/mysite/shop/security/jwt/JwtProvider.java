package com.mysite.shop.security.jwt;

import com.mysite.shop.security.UserPrinciple;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface JwtProvider {
    String generateToken(UserPrinciple auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);

    Claims extractClaims(HttpServletRequest request);
}
