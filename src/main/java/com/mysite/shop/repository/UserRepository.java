package com.mysite.shop.repository;

import com.mysite.shop.model.Role;
import com.mysite.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //findBy + 열이름(대문자시작)
    Optional<User> findByUsername(String username);

    //유저네임으로 찾은 유저의 role 을 업데이트 함(입력,수정,삭제시 @Modifying 붙음)
    @Modifying
    @Query("update User set role=:role where username=:username")
    void updateUserRole(@Param("username") String username, @Param("role") Role role);
}
