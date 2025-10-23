package com.h2.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.h2.entity.db.Book;

// @DataJpaTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class BookServiceTest {
    
    private static final Logger logger = LoggerFactory.getLogger(BookServiceTest.class);
    
    @Autowired
    private BookService bookService;
    
    @Test
    void testGetBooksBySearchTermNull() {
        
        String searchTerm = null;
        assertThrows(IllegalArgumentException.class, () -> {
            bookService.getBooksBySearchTerm(searchTerm);
        });
    }

    @Test
    void testGetBooksBySearchTermEmpty(){
        
        String searchTerm = "";
        assertThrows(IllegalArgumentException.class, () -> {
            bookService.getBooksBySearchTerm(searchTerm);
        });
    }

    @Test
    void testGetBooksBySearchTermValid(){
        
        String searchTerm = "Artificial Intelligence";
        // Further implementation can be added here to test valid search terms
        logger.info("Testing valid search term: {}", searchTerm);
        List<Book> results = bookService.getBooksBySearchTerm(searchTerm);
        assertTrue(results.size() > 0);
    }
}
