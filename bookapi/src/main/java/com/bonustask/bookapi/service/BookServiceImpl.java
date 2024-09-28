package com.bonustask.bookapi.service;

import com.bonustask.bookapi.model.Book;
import com.bonustask.bookapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBookRating(int id, int rating) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setRating(rating);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> filterBooks(String title, String author, Integer publishYear, Integer rating) {
        return bookRepository.findAll().stream()
                .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)))
                .filter(book -> (author == null || book.getAuthor().equalsIgnoreCase(author)))
                .filter(book -> (publishYear == null || book.getPublishYear() == publishYear))
                .filter(book -> (rating == null || book.getRating() == rating))
                .collect(Collectors.toList());
    }
}
