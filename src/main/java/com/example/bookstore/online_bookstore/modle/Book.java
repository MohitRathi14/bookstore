package com.example.bookstore.online_bookstore.modle;
import jakarta.persistence.Column;
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
  @Column(name = "image_name")

  private String imageName;
  
    public Book() {
    }
    public Book(String title, String author, String category, double price, String imageName) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.imageName = imageName;
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
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImageName() {
        return imageName;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
