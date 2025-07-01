package com.example.bookstore.online_bookstore.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.example.bookstore.online_bookstore.modle.User;
import com.example.bookstore.online_bookstore.repositories.UserRepository;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public boolean existsByUsername(String username) {
        return userRepo.findByUsername(username) != null;
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    // For Spring Security
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User not found");

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }
}

