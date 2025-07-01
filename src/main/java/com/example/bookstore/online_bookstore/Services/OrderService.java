package com.example.bookstore.online_bookstore.Services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookstore.online_bookstore.Entity.Order;
import com.example.bookstore.online_bookstore.Entity.User;
import com.example.bookstore.online_bookstore.Entity.OrderItem;
import com.example.bookstore.online_bookstore.Entity.CartItem;
import com.example.bookstore.online_bookstore.Repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CartService cartService;

    public void placeOrder(User user) {
        List<CartItem> cartItems = cartService.getCartItems(user);

        if (cartItems.isEmpty()) return;

        List<OrderItem> orderItems = cartItems.stream().map(item ->
            new OrderItem(
                item.getBook(),
                item.getQuantity(),
                item.getBook().getPrice()
            )
        ).collect(Collectors.toList());

        double total = cartItems.stream()
                .mapToDouble(item -> item.getBook().getPrice() * item.getQuantity())
                .sum();

        Order order = new Order(user, orderItems, total);
        orderRepo.save(order);

        cartService.clearCart(user);
    }

    public List<Order> getUserOrders(User user) {
        return orderRepo.findAll().stream()
            .filter(order -> order.getUser().getId().equals(user.getId()))
            .collect(Collectors.toList());
    }
}