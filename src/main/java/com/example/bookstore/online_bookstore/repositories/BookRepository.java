package com.example.bookstore.online_bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.online_bookstore.modle.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByCategory(String category);
}