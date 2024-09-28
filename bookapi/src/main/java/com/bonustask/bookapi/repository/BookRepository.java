package com.bonustask.bookapi.repository;

import org.springframework.stereotype.Repository;
import com.bonustask.bookapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
}
