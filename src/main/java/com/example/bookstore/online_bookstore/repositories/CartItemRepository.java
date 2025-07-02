package com.example.bookstore.online_bookstore.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

// Update the import paths below if your CartItem and User classes are in a different package.
// For example, if they are in 'models' instead of 'model', update as follows:
// import com.example.bookstore.online_bookstore.models.CartItem;
// import com.example.bookstore.online_bookstore.models.User;

import com.example.bookstore.online_bookstore.modle.User;
import com.example.bookstore.online_bookstore.modle.CartItem;

import java.util.List;
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
}
