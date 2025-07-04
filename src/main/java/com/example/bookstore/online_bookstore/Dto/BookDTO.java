package com.example.bookstore.online_bookstore.Dto;

public class BookDTO {
    private String title;
    private String author;
    private double price;

    public BookDTO() {}
    public BookDTO(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    // Getters and Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    

}
