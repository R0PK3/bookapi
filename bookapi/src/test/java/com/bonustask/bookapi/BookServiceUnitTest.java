package com.bonustask.bookapi;

import com.bonustask.bookapi.model.Book;
import com.bonustask.bookapi.repository.BookRepository;
import com.bonustask.bookapi.service.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
public class BookServiceUnitTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private List<Book> getMockBooks() {
        return Arrays.asList(
                new Book("To Kill a Mockingbird", "Harper Lee", 1960, 5),
                new Book("1984", "George Orwell", 1949, 1),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 2),
                new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 3),
                new Book("The Hobbit", "J.R.R. Tolkien", 1937, 2),
                new Book("Pride and Prejudice", "Jane Austen", 1813, 5),
                new Book("Moby-Dick", "Herman Melville", 1851, 3),
                new Book("War and Peace", "Leo Tolstoy", 1869, 1),
                new Book("The Odyssey", "Homer", -800, 4),
                new Book("Brave New World", "Aldous Huxley", 1932, 4)
        );
    }

    @Test
    public void testFilterBooksByRating_ShouldReturnBooksWithGivenRating() {
        int targetRating = 5;
        List<Book> mockBooks = getMockBooks();

        when(bookRepository.findAll()).thenReturn(mockBooks);
        List<Book> filteredBooks = bookService.filterBooks(null, null, null, targetRating);

        assertEquals(2, filteredBooks.size(), "Should return 2 books with rating 5");
        assertEquals("To Kill a Mockingbird", filteredBooks.get(0).getTitle());
        assertEquals("Pride and Prejudice", filteredBooks.get(1).getTitle());
    }

    @Test
    public void testFilterBooksByTitle_ShouldReturnBooksWithGivenTitle() {
        String targetTitle = "1984";
        List<Book> mockBooks = getMockBooks();

        when(bookRepository.findAll()).thenReturn(mockBooks);
        List<Book> filteredBooks = bookService.filterBooks(targetTitle, null, null, null);

        assertEquals(1, filteredBooks.size(), "Should return 1 book with title '1984'");
        assertEquals("1984", filteredBooks.getFirst().getTitle());
    }

    @Test
    public void testFilterBooksByAuthor_ShouldReturnBooksWithGivenAuthor() {
        String targetAuthor = "Jane Austen";
        List<Book> mockBooks = getMockBooks();

        when(bookRepository.findAll()).thenReturn(mockBooks);
        List<Book> filteredBooks = bookService.filterBooks(null, targetAuthor, null, null);

        assertEquals(1, filteredBooks.size(), "Should return 1 book by author 'Jane Austen'");
        assertEquals("Pride and Prejudice", filteredBooks.getFirst().getTitle());
    }

    @Test
    public void testFilterBooksByPublishYear_ShouldReturnBooksWithGivenYear() {
        int targetYear = 1937;
        List<Book> mockBooks = getMockBooks();

        when(bookRepository.findAll()).thenReturn(mockBooks);
        List<Book> filteredBooks = bookService.filterBooks(null, null, targetYear, null);

        assertEquals(1, filteredBooks.size(), "Should return 1 book published in 1937");
        assertEquals("The Hobbit", filteredBooks.getFirst().getTitle());
    }

    @Test
    public void testFilterBooksByAllFilters_ShouldReturnMatchingBook() {

        String targetTitle = "1984";
        String targetAuthor = "George Orwell";
        int targetYear = 1949;
        int targetRating = 1;

        List<Book> mockBooks = getMockBooks();

        when(bookRepository.findAll()).thenReturn(mockBooks);
        List<Book> filteredBooks = bookService.filterBooks(targetTitle, targetAuthor, targetYear, targetRating);

        assertEquals(1, filteredBooks.size(), "Should return 1 book matching all filters");
        assertEquals("1984", filteredBooks.getFirst().getTitle());
    }
}
