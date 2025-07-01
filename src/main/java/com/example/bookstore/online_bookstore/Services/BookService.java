package com.example.bookstore.online_bookstore.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.online_bookstore.Entity.Book;
import com.example.bookstore.online_bookstore.Repositories.BookRepository;
import java.util.List;

@Service
public class BookService {
     @Autowired private BookRepository bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public List<Book> getByCategory(String category) {
        return bookRepo.findByCategory(category);
    }

    public void addBook(Book book) {
        bookRepo.save(book);
    }
}
