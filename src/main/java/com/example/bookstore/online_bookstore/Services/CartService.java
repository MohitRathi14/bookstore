package com.example.bookstore.online_bookstore.Services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.online_bookstore.Entity.Book;
import com.example.bookstore.online_bookstore.Entity.CartItem;
import com.example.bookstore.online_bookstore.Entity.User;
import com.example.bookstore.online_bookstore.Repositories.CartItemRepository;
import com.example.bookstore.online_bookstore.Dto.CartItemDTO;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepo;

    public void addToCart(User user, Book book) {
        CartItem existingItem = cartItemRepo.findByUser(user).stream()
            .filter(item -> item.getBook().getId().equals(book.getId()))
            .findFirst()
            .orElse(null);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + 1);
            cartItemRepo.save(existingItem);
        } else {
            CartItem newItem = new CartItem(book, user, 1);
            cartItemRepo.save(newItem);
        }
    }

    public List<CartItemDTO> getCartDTOList(User user) {
        return cartItemRepo.findByUser(user).stream()
            .map(item -> new CartItemDTO(
                item.getBook().getTitle(),
                item.getBook().getPrice(),
                item.getQuantity()
            ))
            .collect(Collectors.toList());
    }

    public double getCartTotal(User user) {
        return cartItemRepo.findByUser(user).stream()
            .mapToDouble(item -> item.getBook().getPrice() * item.getQuantity())
            .sum();
    }

    public void removeCartItem(Long itemId) {
        cartItemRepo.deleteById(itemId);
    }

    public List<CartItem> getCartItems(User user) {
        return cartItemRepo.findByUser(user);
    }

    public void clearCart(User user) {
        List<CartItem> items = cartItemRepo.findByUser(user);
        cartItemRepo.deleteAll(items);
    }
}