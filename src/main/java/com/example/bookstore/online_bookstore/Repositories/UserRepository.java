package com.example.bookstore.online_bookstore.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bookstore.online_bookstore.Entity.User;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
