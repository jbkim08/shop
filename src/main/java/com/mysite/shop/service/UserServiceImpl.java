package com.mysite.shop.service;

import com.mysite.shop.model.Role;
import com.mysite.shop.model.User;
import com.mysite.shop.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

    //유저네임으로 해당유저를 DB에서 찾기
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    //유저의 role을 업데이트 하기
    @Override
    @Transactional  //update,delete 에 사용해서 안정성 보장
    public void changeRole(Role newRole, String username){
        userRepository.updateUserRole(username, newRole);
    }

}








