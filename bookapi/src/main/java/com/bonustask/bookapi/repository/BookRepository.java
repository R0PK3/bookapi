package com.bonustask.bookapi.repository;

import org.springframework.stereotype.Repository;
import com.bonustask.bookapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByPublishYear(int publishYear);
    List<Book> findByRating(int rating);
}
