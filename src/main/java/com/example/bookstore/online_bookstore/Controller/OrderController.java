package com.example.bookstore.online_bookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import com.example.bookstore.online_bookstore.Services.OrderService;
import com.example.bookstore.online_bookstore.Services.UserService;
import com.example.bookstore.online_bookstore.Dto.OrderDTO;
import com.example.bookstore.online_bookstore.modle.Order;
import com.example.bookstore.online_bookstore.modle.User;


@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    // Show user's order history
    @GetMapping("/orders")
    public String viewOrders(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        List<Order> orders = orderService.getUserOrders(user);

        // Convert to DTOs
        List<OrderDTO> orderDTOs = orders.stream()
            .map(orderService::convertToOrderDTO)
            .collect(Collectors.toList());

        model.addAttribute("orders", orderDTOs);
        return "orders"; // Thymeleaf page to show order history
    }
}
