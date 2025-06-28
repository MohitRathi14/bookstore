package com.example.bookstore.online_bookstore.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.bookstore.online_bookstore.Entity.CartItem;
import com.example.bookstore.online_bookstore.Entity.User;
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
}
