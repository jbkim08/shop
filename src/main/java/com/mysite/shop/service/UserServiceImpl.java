package com.mysite.shop.service;

import com.mysite.shop.model.Role;
import com.mysite.shop.model.User;
import com.mysite.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    //롬북이 생성자를 자동으로 만들어주고 객체는 생성자 주입
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }

}
