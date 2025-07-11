package com.example.bookstore.online_bookstore.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.File;
import java.util.UUID;
import com.example.bookstore.online_bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.bookstore.online_bookstore.Services.BookService;
import com.example.bookstore.online_bookstore.modle.Book;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    AdminController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Show book list in admin panel
    @GetMapping("/books")
    public String adminBookList(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "admin-books";
    }

    // Show form to add a new book
    @GetMapping("/books/new")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }

    // Save new or updated book
   @PostMapping("books/save")
public String saveBook(@ModelAttribute Book book, @RequestParam("image") MultipartFile file) throws IOException {
    if (!file.isEmpty()) {
        String uploadDir = System.getProperty("user.dir") + File.separator + "uploads";
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        file.transferTo(filePath.toFile());

        book.setImageName(fileName);
    }

    bookRepository.save(book);
    return "redirect:/admin/books";
}


    // Show form to edit book
    @GetMapping("/books/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book-form";
    }

    // Delete a book
    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/admin/books";
    }
}
