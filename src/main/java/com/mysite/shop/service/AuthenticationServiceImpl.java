package com.mysite.shop.service;

import com.mysite.shop.model.User;
import com.mysite.shop.security.UserPrinciple;
import com.mysite.shop.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
    // 필요한 객체를 생성자 주입받음
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    //유저네임과 패스워드로 로그인후 토큰을 만들어 리턴
    @Override
    public User signInAndReturnJWT(User signInRequest){
        //스프링 시큐리티에서 로그인하기
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrinciple); //로그인된 유저정보로 jwt 토큰 만들기

        User signInUser = userPrinciple.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }

}
