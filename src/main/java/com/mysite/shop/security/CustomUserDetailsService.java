package com.mysite.shop.security;

import com.mysite.shop.model.User;
import com.mysite.shop.service.UserService;
import com.mysite.shop.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //DB 에서 유저 검색
        User user = userService.findByUsername(username)
                        .orElseThrow(()->new UsernameNotFoundException(username));
        //user 의 role 을 스프링시큐리티의 GrantedAuthority 로 바꿔준다. 여러개의 role을 가질수 있으므로 Set
        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

        return UserPrinciple.builder()
                .user(user)
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
