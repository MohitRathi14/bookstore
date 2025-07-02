package com.example.bookstore.online_bookstore.Services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.online_bookstore.Dto.OrderDTO;
import com.example.bookstore.online_bookstore.Dto.OrderItemDTO;
import com.example.bookstore.online_bookstore.modle.CartItem;
import com.example.bookstore.online_bookstore.modle.Order;
import com.example.bookstore.online_bookstore.modle.OrderItem;
import com.example.bookstore.online_bookstore.modle.User;
import com.example.bookstore.online_bookstore.repositories.OrderRepository;

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
    public OrderDTO convertToOrderDTO(Order order) {
        List<OrderItemDTO> itemDTOs = order.getItems().stream()
            .map(item -> new OrderItemDTO(
                item.getBook().getTitle(),
                item.getQuantity(),
                item.getPrice()
        ))
        .collect(Collectors.toList());

        return new OrderDTO(
            order.getId(),
            order.getTotalAmount(),
            order.getOrderDate(),
            itemDTOs
        );
}

}