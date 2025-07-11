package com.example.bookstore.online_bookstore.Controller;
import com.example.bookstore.online_bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.bookstore.online_bookstore.Services.BookService;
import com.example.bookstore.online_bookstore.modle.Book;

import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



@Controller
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

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
    
    @PostMapping("/admin/books/update")
    public String updateBook(@ModelAttribute Book book, @RequestParam("image") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String uploadDir = "uploads/";
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        file.transferTo(filePath.toFile());

        book.setImageName(fileName); // override with new image
        } 
        else {
            // Keep the original image if no new one is uploaded
            Book existing = bookRepository.findById(book.getId()).orElse(null);
            if (existing != null) {
                book.setImageName(existing.getImageName());
            }
        }

        bookRepository.save(book);
        return "redirect:/admin/books";
    }
   

}