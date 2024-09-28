package com.bonustask.bookapi.service;

import com.bonustask.bookapi.model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book updateBookRating(int id, int rating);
    List<Book> filterBooks(String title, String author, Integer publishYear, Integer rating);
}
