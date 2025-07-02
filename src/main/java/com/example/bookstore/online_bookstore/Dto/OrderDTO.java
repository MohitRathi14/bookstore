package com.example.bookstore.online_bookstore.Dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private Long orderId;
    private double totalAmount;
    private LocalDateTime orderDate;
    private List<OrderItemDTO> items;

    public OrderDTO() {
    }
    public OrderDTO(Long orderId, double totalAmount, LocalDateTime orderDate, List<OrderItemDTO> items) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.items = items;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    public List<OrderItemDTO> getItems() {
        return items;
    }
    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
