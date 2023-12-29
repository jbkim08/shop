package com.mysite.shop.security.jwt;

import com.mysite.shop.security.UserPrinciple;

public interface JwtProvider {
    String generateToken(UserPrinciple auth);
}
