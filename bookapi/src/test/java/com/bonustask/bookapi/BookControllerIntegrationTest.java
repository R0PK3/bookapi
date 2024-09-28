package com.bonustask.bookapi;

import com.bonustask.bookapi.model.Book;
import com.bonustask.bookapi.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

@SpringBootTest(classes = BookapiApplication.class)
@AutoConfigureMockMvc
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository.deleteAll();

        bookRepository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 5));
        bookRepository.save(new Book("1984", "George Orwell", 1949, 1));
        bookRepository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 2));
        bookRepository.save(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 3));
        bookRepository.save(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 2));
        bookRepository.save(new Book("Pride and Prejudice", "Jane Austen", 1813, 5));
        bookRepository.save(new Book("Moby-Dick", "Herman Melville", 1851, 3));
        bookRepository.save(new Book("War and Peace", "Leo Tolstoy", 1869, 1));
        bookRepository.save(new Book("The Odyssey", "Homer", -800, 4));
        bookRepository.save(new Book("Brave New World", "Aldous Huxley", 1932, 4));
    }

    @Test
    public void testGetBooksByRating_ShouldReturnBooksWithGivenRating() throws Exception {
        mockMvc.perform(get("/api/books/filter")
                        .param("rating", "5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("To Kill a Mockingbird")))
                .andExpect(jsonPath("$[1].title", is("Pride and Prejudice")));
    }
}
