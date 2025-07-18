package com.example.bookstore.online_bookstore.Dto;

public class CartItemDTO {

    private String bookTitle;
    private double bookPrice;
    private int quantity;
    private double totalPrice;
    private long bookId;

    public CartItemDTO() {}

    public CartItemDTO(String bookTitle, double bookPrice, int quantity, long bookId) {
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
        this.quantity = quantity;
        this.totalPrice = bookPrice * quantity;
        this.bookId = bookId;
    }

    // Getters and Setters

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalPrice = this.bookPrice * quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public void setBookID(long bookId) {
        this.bookId = bookId;
    }
    public long getBookId() {
        return bookId;
    }
}