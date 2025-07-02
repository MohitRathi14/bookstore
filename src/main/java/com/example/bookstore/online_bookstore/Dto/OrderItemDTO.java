package com.example.bookstore.online_bookstore.Dto;

public class OrderItemDTO {

    private String bookTitle;
    private int quantity;
    private double unitPrice;
    private double totalPrice;

    public OrderItemDTO() {}

    public OrderItemDTO(String bookTitle, int quantity, double unitPrice) {
        this.bookTitle = bookTitle;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = quantity * unitPrice;
    }

    // Getters and Setters

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalPrice = this.unitPrice * quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        this.totalPrice = this.unitPrice * quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
