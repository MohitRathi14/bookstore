package com.example.bookstore.online_bookstore.Entity;


import jakarta.persistence.*;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One cart item is associated with one book
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // One cart item is associated with one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int quantity;

    public CartItem() {
    }

    public CartItem(Book book, User user, int quantity) {
        this.book = book;
        this.user = user;
        this.quantity = quantity;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
