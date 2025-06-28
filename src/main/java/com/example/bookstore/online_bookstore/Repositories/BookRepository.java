package com.example.bookstore.online_bookstore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.bookstore.online_bookstore.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByCategory(String category);
}