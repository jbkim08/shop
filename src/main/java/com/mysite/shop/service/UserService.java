package com.mysite.shop.service;

import com.mysite.shop.model.Role;
import com.mysite.shop.model.User;

import java.util.Optional;

public interface UserService {
    //새 유저 저장
    User saveUser(User user);

    //유저네임으로 해당유저를 DB에서 찾기
    Optional<User> findByUsername(String username);

    //유저의 role을 업데이트 하기
    void changeRole(Role newRole, String username);
}
