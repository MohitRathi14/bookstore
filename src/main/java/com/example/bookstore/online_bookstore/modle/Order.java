package com.example.bookstore.online_bookstore.modle;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "orders")  // "order" is a reserved word in SQL
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Who placed the order
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // List of books in the order
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;

    private double totalAmount;

    private LocalDateTime orderDate;

    public Order() {
        this.orderDate = LocalDateTime.now();
    }

    public Order(User user, List<OrderItem> items, double totalAmount) {
        this.user = user;
        this.items = items;
        this.totalAmount = totalAmount;
        this.orderDate = LocalDateTime.now();
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}
