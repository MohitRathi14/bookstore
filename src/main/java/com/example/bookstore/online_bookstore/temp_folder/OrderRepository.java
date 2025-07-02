package com.example.bookstore.online_bookstore.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.online_bookstore.modle.Order;
public interface OrderRepository extends JpaRepository<Order, Long> {
}
