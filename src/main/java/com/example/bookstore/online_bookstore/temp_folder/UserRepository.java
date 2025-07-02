package com.example.bookstore.online_bookstore.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.online_bookstore.modle.User;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
