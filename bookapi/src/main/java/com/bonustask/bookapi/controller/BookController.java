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

    @GetMapping("/filter")
    public List<Book> filterBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer publishYear,
            @RequestParam(required = false) Integer rating) {
        return bookService.filterBooks(title, author, publishYear, rating);
    }
}
