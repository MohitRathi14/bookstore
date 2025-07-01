package com.example.bookstore.online_bookstore.modle;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Book {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String author;
  private String category;
  private double price;
  private int stock;
  
    public Book() {
    }
    public Book(String title, String author, String category, double price, int stock) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

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
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }   
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }   
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
