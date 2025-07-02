package com.example.bookstore.online_bookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.bookstore.online_bookstore.Services.BookService;
import com.example.bookstore.online_bookstore.modle.Book;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    // Show all books
    @GetMapping("/books")
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books"; // books.html
    }

    // Show books by category
    @GetMapping("/books/category/{category}")
    public String listBooksByCategory(@PathVariable String category, Model model) {
        List<Book> books = bookService.getByCategory(category);
        model.addAttribute("books", books);
        model.addAttribute("selectedCategory", category);
        return "books"; // same view as above, just filtered
    }
}