package com.bonustask.bookapi.controller;

import com.bonustask.bookapi.model.Book;
import com.bonustask.bookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/filter")
    public List<Book> filterBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer publishYear,
            @RequestParam(required = false) Integer rating) {
        return bookService.filterBooks(title, author, publishYear, rating);
    }

    @PutMapping("/rate/{id}")
    public Book updateBookRating(@PathVariable int id, @RequestParam String rating) {
        try {
            int parsedRating = Integer.parseInt(rating);

            if (parsedRating < 1 || parsedRating > 5) {
                throw new IllegalArgumentException("Rating must be between 1 and 5");
            }

            return bookService.updateBookRating(id, parsedRating);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid rating: must be a number between 1 and 5");
        }
    }
}
