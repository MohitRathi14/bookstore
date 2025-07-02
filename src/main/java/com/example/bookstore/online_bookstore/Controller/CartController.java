package com.example.bookstore.online_bookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.bookstore.online_bookstore.Dto.CartItemDTO;
import com.example.bookstore.online_bookstore.Services.CartService;
import com.example.bookstore.online_bookstore.Services.BookService;
import com.example.bookstore.online_bookstore.Services.UserService;
import com.example.bookstore.online_bookstore.modle.Book;
import com.example.bookstore.online_bookstore.modle.User;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired private CartService cartService;
    @Autowired private BookService bookService;
    @Autowired private UserService userService;

    // View Cart Items
    @GetMapping
    public String viewCart(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        List<CartItemDTO> items = cartService.getCartDTOList(user);
        model.addAttribute("cartItems", items);
        model.addAttribute("total", cartService.getCartTotal(user));
        return "cart";
    }

    // Add Book to Cart
    @PostMapping("/add/{bookId}")
    public String addToCart(@PathVariable Long bookId, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Book book = bookService.findById(bookId);
        if (book == null) {
            return "redirect:/books"; // Redirect if book not found
        }
        cartService.addToCart(user, book);
        return "redirect:/cart";
    }

    // Remove Item from Cart
    @PostMapping("/remove/{itemId}")
    public String removeFromCart(@PathVariable Long itemId) {
        cartService.removeCartItem(itemId);
        return "redirect:/cart";
    }


    // Clear Cart
    @PostMapping("/clear")
    public String clearCart(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        cartService.clearCart(user);
        return "redirect:/cart";
    }
}
