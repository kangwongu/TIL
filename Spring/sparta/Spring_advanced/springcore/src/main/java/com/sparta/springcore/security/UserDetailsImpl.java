package com.sparta.springcore.security;

import com.sparta.springcore.model.User;
import com.sparta.springcore.model.UserRoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// 스프링 시큐리티의 UserDetails 구현
public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // 권한 설정
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 1. 로그인된 회원의 역할 정보를 확인해 USER인지 ADMIN인지 확인한다
        UserRoleEnum role = user.getRole();
        String authority = role.getAuthority(); // ROLE_ADMIN, ROLE_USER

        // 2. 해당 역할에 맞게 권한을 설정한다.
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        // 스프링 시큐리티가 알아서 권한을 확인
        return authorities;
    }
}
