package com.mysite.shop.service;

import com.mysite.shop.model.User;

public interface AuthenticationService {
    //유저네임과 패스워드로 로그인후 토큰을 만들어 리턴
    User signInAndReturnJWT(User signInRequest);
}
