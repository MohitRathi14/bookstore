package com.example.bookstore.online_bookstore.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bookstore.online_bookstore.Entity.Order;
public interface OrderRepository extends JpaRepository<Order, Long> {
}
