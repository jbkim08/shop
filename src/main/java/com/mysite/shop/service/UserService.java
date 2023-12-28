package com.mysite.shop.service;

import com.mysite.shop.model.Role;
import com.mysite.shop.model.User;

public interface UserService {
    User saveUser(User user);

    //유저의 role을 업데이트 하기
    void changeRole(Role newRole, String username);
}
